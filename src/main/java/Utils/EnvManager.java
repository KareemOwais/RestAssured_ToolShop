package Utils;
import io.github.cdimascio.dotenv.Dotenv;

public class EnvManager {
    private static Dotenv dotenv;

    private static Boolean CheckLocalEnv() {
        try {
            dotenv = Dotenv.load();
            return true;
        } catch (Exception e) {
            dotenv = null;
            return false;
        }
    }
    public static String getEnvVar(String key) {
        String value ;
        if(!CheckLocalEnv()) {
             value = System.getenv(key);
        }
        else{
            value = dotenv.get(key);
        }
        return value;
    }
}



