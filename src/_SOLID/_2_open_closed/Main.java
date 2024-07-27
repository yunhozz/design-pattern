package _SOLID._2_open_closed;

import _SOLID._2_open_closed.compliant.Report;
import _SOLID._2_open_closed.compliant.report.HTMLReport;
import _SOLID._2_open_closed.compliant.report.PDFReport;
import _SOLID._2_open_closed.compliant.report.XMLReport;

public class Main {

    public static void main(String[] args) {
        Report pdfReport = new PDFReport();
        pdfReport.generate();  // Generating PDF report...

        Report htmlReport = new HTMLReport();
        htmlReport.generate();  // Generating HTML report...

        Report xmlReport = new XMLReport();
        xmlReport.generate();  // Generating XML report...
    }
}
