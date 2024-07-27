package _SOLID._2_open_closed.compliant.report;

import _SOLID._2_open_closed.compliant.Report;

public class PDFReport implements Report {

    @Override
    public void generate() {
        System.out.println("Generating PDF report...");
    }
}
