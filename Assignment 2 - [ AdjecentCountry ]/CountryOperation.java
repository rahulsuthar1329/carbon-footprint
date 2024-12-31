package adjecentCountries;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class CountryOperation {
    private static String fetchCountryName(String countryCode) throws IOException, InterruptedException {
        String countryDetailsURI = "https://restcountries.com/v3.1/alpha/" + countryCode;
        var request = HttpRequest.newBuilder().GET().uri(URI.create(countryDetailsURI)).build();

        var httpClient = HttpClient.newBuilder().build();
        var countryResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonFormattedCountryResponse = mapper.readTree(countryResponse.body());

        return jsonFormattedCountryResponse.get(0).get("name").get("common").asText();
    }

    public static List<String> fetchAdjacentCountries(String countryCode) throws IOException, InterruptedException {
        String adjacentCountryURI = "https://www.apicountries.com/borders/" + fetchCountryName(countryCode);
        var request = HttpRequest.newBuilder().GET().uri(URI.create(adjacentCountryURI)).build();
        List<String> adjacentCountries = new ArrayList<>();

        var client = HttpClient.newBuilder().build();
        var adjacentCountryResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonFormattedCountryResponse = mapper.readTree(adjacentCountryResponse.body());

        for(var country: jsonFormattedCountryResponse){
            adjacentCountries.add(country.get("name").asText());
        }

        return adjacentCountries;
    }
}