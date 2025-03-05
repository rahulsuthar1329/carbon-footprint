class TumblrServiceImpl implements TumblrService {
    @Override
    public void fetchTumblrData(String blogName, int start, int end) {
        try {
            String apiUrl = "https://" + blogName + ".tumblr.com/api/read/json?type=photo&num=" + (end - start + 1)
                    + "&start=" + (start - 1);

            HttpURLConnection conn = (HttpURLConnection) new URL(apiUrl).openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                System.out.println("Error: Unable to fetch data. Please check the blog name and try again.");
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Extract JSON content
            String jsonResponse = response.toString().replace("var tumblr_api_read =", "").trim();
            jsonResponse = jsonResponse.substring(0, jsonResponse.length() - 1);

            parseAndDisplayData(jsonResponse, start);
        } catch (Exception e) {
            System.out.println("Error fetching or parsing data: " + e.getMessage());
        }
    }

    private void parseAndDisplayData(String jsonResponse, int start) {
        JSONObject data = new JSONObject(jsonResponse);

        JSONObject tumblelog = data.getJSONObject("tumblelog");
        System.out.println("\nTitle: " + tumblelog.getString("title"));
        System.out.println("Name: " + tumblelog.getString("name"));
        System.out.println("Description: " + tumblelog.getString("description"));
        System.out.println("Total Posts: " + data.getInt("posts-total") + "\n");

        // Extract image URLs
        JSONArray posts = data.getJSONArray("posts");
        for (int i = 0; i < posts.length(); i++) {
            JSONObject post = posts.getJSONObject(i);
            if (post.has("photos")) {
                JSONArray photos = post.getJSONArray("photos");
                for (int j = 0; j < photos.length(); j++) {
                    JSONObject photo = photos.getJSONObject(j);
                    System.out.println((start + i) + ". " + photo.getString("photo-url-1280"));
                }
            }
        }
    }
}