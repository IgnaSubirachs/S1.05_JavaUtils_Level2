import java.io.*;

public class DirectoryExporter {

    public static void exportDirectoryToFile(File directory, File outputFile) throws DirectoryException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            DirectoryUtils.listDirectory(directory, 0, writer);
            System.out.println("✅ Directory exported to: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            throw new DirectoryException("Error writing to file: " + e.getMessage());
        }
    }
}
