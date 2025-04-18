import org.apache.commons.configuration2.Configuration;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class DirectoryExporter {

    public static void exportDirectoryToFile(Configuration config) throws DirectoryException {
        String inputDirectoryPath = config.getString("input.directory");
        String outputFilePath = config.getString("output.file");

        File directory = new File(inputDirectoryPath);
        File outputFile = new File(outputFilePath);

        if (!directory.exists() || !directory.isDirectory()) {
            throw new DirectoryException("Directory does not exist or is not a directory: " + inputDirectoryPath);
        }

        System.out.println("Absolute path: " + directory.getAbsolutePath());

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            File[] files = directory.listFiles();
            if (files == null) {
                throw new DirectoryException("Error reading directory contents");
            }

            Arrays.sort(files);

            for (File file : files) {
                if (file.isDirectory()) {
                    writer.println("(D) " + file.getName() + "/");

                    File[] subfiles = file.listFiles();

                    if (subfiles != null && subfiles.length > 0) {
                        Arrays.sort(subfiles);
                        for (File subfile : subfiles) {
                            String type = subfile.isDirectory() ? "(D)" : "(F)";
                            writer.println("    " + type + " " + subfile.getName());
                        }
                    } else {
                        writer.println("    (empty folder)");
                    }

                } else {
                    writer.println("(F) " + file.getName());
                }
            }

            System.out.println("✅ Export complete: " + outputFile.getAbsolutePath());

        } catch (IOException e) {
            throw new DirectoryException("Error writing to file: " + e.getMessage());
        }
    }
}
