package adjecentCountries;

import java.io.IOException;
import java.util.Scanner;

public class AdjacentCountry {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the country code : ");
        String countryCode = scanner.nextLine();

        System.out.printf("\n----------- [ Adjacent Countries of %s ] -----------\n", countryCode);
        for(String country: CountryOperation.fetchAdjacentCountries(countryCode)){
            System.out.println(country);
        }
    }
}
