package structure.proxy;

interface Document {
    void display();
}

class RealDocument implements Document {
    private final String fileName;

    public RealDocument(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk() {
        System.out.println("Loading " + fileName + " from disk");
    }
}

class ProxyDocument implements Document {
    private final String fileName;
    private RealDocument realDocument;

    public ProxyDocument(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realDocument == null) {
            realDocument = new RealDocument(fileName);
        }
        realDocument.display();
    }
}

class DocumentDemo {
    public static void main(String[] args) {
        Document document = new ProxyDocument("important_file.pdf");

        System.out.println("First access:");
        document.display();

        System.out.println("\nSecond access:");
        document.display();
    }
}