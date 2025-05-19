package Utils;
import io.github.cdimascio.dotenv.Dotenv;

public class EnvManager {
    private static Dotenv dotenv;
    public static String getEnvVar(String key) {
        try {
            dotenv = Dotenv.load();
        } catch (Exception e) {
            System.out.println(".env File Not Found , Running in GitHub Actions");
            dotenv = null;
        }
        String value = System.getenv(key); // Get Environment variable from GitHub Secrets

        if (value == null && dotenv != null) {
            value = dotenv.get(key);
        }

        return value;
    }
}



