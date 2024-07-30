package behavior.template_method.data_processor;

public class CSVDataProcessor extends DataProcessor {

    @Override
    protected void loadData(String data) {
        System.out.println("Loading data from CSV file: " + data);
    }

    @Override
    protected boolean isValidData(String data) {
        return data != null && data.contains("CSV");
    }

    @Override
    protected void processData(String data) {
        System.out.println("Processing CSV data");
    }

    @Override
    protected void saveData(String data) {
        System.out.println("Saving CSV data to database");
    }
}