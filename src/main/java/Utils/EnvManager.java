package Utils;
import io.github.cdimascio.dotenv.Dotenv;

public class EnvManager {
    private static final Dotenv dotenv = Dotenv.load();

        public static String getEnvVar(String key) {
            String value = System.getenv(key);    // For GitHub Actions
            if (value == null) {
                value = dotenv.get(key);          // Locally
            }
            return value;
        }
    }


