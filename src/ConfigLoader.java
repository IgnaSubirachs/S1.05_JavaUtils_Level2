
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ConfigLoader {

    public static FileInputStream loadConfiguration() throws FileNotFoundException {
        return new FileInputStream("config.properties");
    }
}
