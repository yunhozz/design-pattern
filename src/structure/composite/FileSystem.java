package structure.composite;

import java.util.ArrayList;
import java.util.List;

// Component
abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public abstract void showDetails();

    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot add component to this item");
    }

    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Cannot remove component from this item");
    }

    public FileSystemComponent getChild(int index) {
        throw new UnsupportedOperationException("Cannot get child from this item");
    }
}

// Leaf
class File extends FileSystemComponent {
    public File(String name) {
        super(name);
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

// Composite
class Directory extends FileSystemComponent {
    private final List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }

    @Override
    public void add(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void remove(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public FileSystemComponent getChild(int index) {
        return components.get(index);
    }
}

class FileSystemDemo {
    public static void main(String[] args) {
        // Creating leaf objects
        FileSystemComponent file1 = new File("file1.txt");
        FileSystemComponent file2 = new File("file2.txt");
        FileSystemComponent file3 = new File("file3.txt");

        // Creating composite objects
        Directory directory1 = new Directory("dir1");
        Directory directory2 = new Directory("dir2");
        Directory rootDirectory = new Directory("root");

        // Composing the file system
        directory1.add(file1);
        directory1.add(file2);
        directory2.add(file3);

        rootDirectory.add(directory1);
        rootDirectory.add(directory2);

        rootDirectory.showDetails(); // Showing all details
    }
}