package http_methods;

import java.io.*;
import java.net.URL;

public class HttpStatusImageDownloader {
    private final int byteLength = 4096;

    public void downloadStatusImage(int code) {
        String filePath = "src\\main\\resources\\http-cat-" + code + ".jpg";

        try {
            URL imageUrl = HttpStatusChecker.getStatusImage(code);

            if (imageUrl != null) {
                try (InputStream inputStream = imageUrl.openStream()) {
                    File outputFile = new File(filePath);

                    try (OutputStream out = new FileOutputStream(outputFile)) {
                        byte[] buffer = new byte[byteLength];
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
