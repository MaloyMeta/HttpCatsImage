import http_methods.HttpImageStatusCli;

public class App {
    public static void main(String[] args) {
        HttpImageStatusCli http = new HttpImageStatusCli();

        http.askStatus();
    }
}
