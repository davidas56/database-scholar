import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AuthorAPIModel {
    private String apiKey;

    public AuthorAPIModel(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getAuthorData(String authorId) throws IOException {
        String urlString = "https://api.scholar.google.com/citations?author=" + authorId + "&hl=en&cstart=0&pagesize=100&key=" + apiKey;
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
