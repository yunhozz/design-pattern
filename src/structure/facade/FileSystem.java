package structure.facade;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class FileReader {
    public String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}

class FileWriter {
    public void writeFile(String filePath, String content) throws IOException {
        Files.write(Paths.get(filePath), content.getBytes());
    }
}

class FileDeleter {
    public void deleteFile(String filePath) throws IOException {
        Files.delete(Paths.get(filePath));
    }
}

class FileSystemFacade {
    private final FileReader fileReader;
    private final FileWriter fileWriter;
    private final FileDeleter fileDeleter;

    public FileSystemFacade() {
        this.fileReader = new FileReader();
        this.fileWriter = new FileWriter();
        this.fileDeleter = new FileDeleter();
    }

    public String readFile(String filePath) {
        try {
            return fileReader.readFile(filePath);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    public boolean writeFile(String filePath, String content) {
        try {
            fileWriter.writeFile(filePath, content);
            return true;
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteFile(String filePath) {
        try {
            fileDeleter.deleteFile(filePath);
            return true;
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
            return false;
        }
    }
}

// Client code demonstrating the use of FileSystemFacade
class FileSystemDemo {
    public static void main(String[] args) {
        FileSystemFacade fs = new FileSystemFacade();

        // Write to file
        boolean writeSuccess = fs.writeFile("test.txt", "Hello, Facade Pattern!");
        System.out.println("File write success: " + writeSuccess);

        // Read from file
        String content = fs.readFile("test.txt");
        System.out.println("File content: " + content);

        // Delete file
        boolean deleteSuccess = fs.deleteFile("test.txt");
        System.out.println("File delete success: " + deleteSuccess);
    }
}