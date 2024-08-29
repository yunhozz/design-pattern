package creation.prototype;

interface Document extends Cloneable {
    // Clone method for creating a copy of the document
    Document clone();
    void setContent(String content);
    String getContent();
}

class Report implements Document {
    private String content;

    public Report(String content) {
        this.content = content;
    }

    // Implementing the clone method to create a copy of the document
    @Override
    public Document clone() {
        return new Report(this.content);
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}

class DocumentClient {
    public static void main(String[] args) {
        // Create an original document template
        Report originalReport = new Report("Company Annual Report Template");

        // Clone the original document to create a new report
        Report clonedReport = (Report) originalReport.clone();

        // Customize the content of the cloned report
        clonedReport.setContent("Company Annual Report for 2024");

        // Display contents to show that they are separate documents
        System.out.println("Original report content: " + originalReport.getContent());
        System.out.println("Cloned report content: " + clonedReport.getContent());

        clonedReport.setContent("Updated Company Annual Report for 2024");

        System.out.println("After changing the cloned report's content:");
        System.out.println("Original report content: " + originalReport.getContent());
        System.out.println("Cloned report content: " + clonedReport.getContent());
    }
}

/*
Original report content: Company Annual Report Template
Cloned report content: Company Annual Report for 2024
After changing the cloned report's content:
Original report content: Company Annual Report Template
Cloned report content: Updated Company Annual Report for 2024
 */