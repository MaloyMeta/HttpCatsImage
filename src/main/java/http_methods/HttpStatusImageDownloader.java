package http_methods;

import java.io.*;
import java.net.URL;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) {
        String filePath = "C:\\Users\\Maloy\\IdeaProjects\\HttpCatsImage\\src\\main\\resources\\http-cat-" + code + ".jpg";

        try {
            URL imageUrl = HttpStatusChecker.getStatusImage(code);

            if (imageUrl != null) {
                try (InputStream inputStream = imageUrl.openStream()) {
                    File outputFile = new File(filePath);

                    try (OutputStream out = new FileOutputStream(outputFile)) {
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            out.write(buffer, 0, bytesRead);
                        }
                        System.out.println("Download success!");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error while download! " + e.getMessage());
        }
    }
}
