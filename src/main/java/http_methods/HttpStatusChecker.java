package http_methods;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public static URL getStatusImage(int code) throws IOException {
        String imageUrl = "https://http.cat/" + code + ".jpg";
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode != 404) {
            return url;
        }
        return null;
    }
}
