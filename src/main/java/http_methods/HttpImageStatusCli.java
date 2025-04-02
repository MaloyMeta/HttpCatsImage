package http_methods;

import java.util.Scanner;

public class HttpImageStatusCli {

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Enter HTTP status code or 'close' to exit:");

                String clientResponse = scanner.nextLine();

                if (clientResponse.equalsIgnoreCase("close")) {
                    System.out.println("Exiting...");
                    break;
                }

                try {
                    int statusCode = Integer.parseInt(clientResponse);

                    HttpStatusImageDownloader hsid = new HttpStatusImageDownloader();
                    hsid.downloadStatusImage(statusCode);

                } catch (NumberFormatException e) {
                    System.out.println("Please enter valid number.");
                } catch (Exception e) {
                    System.out.println("There is not image for HTTP status " + clientResponse);
                }
            }
        } finally {
            scanner.close();
        }
    }
}
