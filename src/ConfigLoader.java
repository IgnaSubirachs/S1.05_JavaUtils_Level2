import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

public class ConfigLoader {

    public static Configuration loadConfiguration() {
        Configurations configs = new Configurations();
        try {
            Configuration config = configs.properties(new File("config.properties"));
            return config;
        } catch (ConfigurationException e) {
            System.err.println("Configuration Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
