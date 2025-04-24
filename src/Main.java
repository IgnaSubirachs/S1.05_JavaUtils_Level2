import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties prop = new Properties();
        try {
            prop.load(ConfigLoader.loadConfiguration());
            File output = new File(prop.getProperty("output.file"));
            File inputFile = new File(prop.getProperty("input.directory"));
            DirectoryExporter.exportDirectoryToFile(inputFile,output);
        } catch (IOException e) {
            System.err.println(" Error exporting directory: " + e.getMessage());

        } catch (DirectoryException e) {
            throw new RuntimeException(e);
        }
    }
}
