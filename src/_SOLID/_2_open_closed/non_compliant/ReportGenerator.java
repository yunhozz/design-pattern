package _SOLID._2_open_closed.non_compliant;

public class ReportGenerator {

    public void generateReport(String type) {
        if (type.equals("PDF")) {
            System.out.println("Generating PDF report...");
        } else if (type.equals("HTML")) {
            System.out.println("Generating HTML report...");
        }
        // If we need to add another format, we have to modify this method.
    }
}
