package structure.facade.file_system;

public class Main {
    public static void main(String[] args) {
        FileSystemFacade fs = new FileSystemFacade();

        boolean writeSuccess = fs.writeFile("test.txt", "Hello, Facade Pattern!");
        System.out.println("File write success: " + writeSuccess);

        String content = fs.readFile("test.txt");
        System.out.println("File content: " + content);

        boolean deleteSuccess = fs.deleteFile("test.txt");
        System.out.println("File delete success: " + deleteSuccess);
    }
}