public class Main {
    public static void main(String[] args) {
        try {
            DirectoryExporter.exportDirectoryToFile(ConfigLoader.loadConfiguration());
        } catch (DirectoryException e) {
            System.err.println(" Error exporting directory: " + e.getMessage());
        }
    }
}
