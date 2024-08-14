package behavior.template_method;

abstract class DataProcessor {
    public final void process(String data) {
        loadData(data);
        if (isValidData(data)) {
            processData(data);
            saveData(data);
        } else {
            System.out.println("Data is invalid, processing aborted.");
        }
    }

    protected abstract void loadData(String data);
    protected abstract boolean isValidData(String data);
    protected abstract void processData(String data);
    protected abstract void saveData(String data);
}

class CSVDataProcessor extends DataProcessor {
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

class JSONDataProcessor extends DataProcessor {
    @Override
    protected void loadData(String data) {
        System.out.println("Loading data from JSON file: " + data);
    }

    @Override
    protected boolean isValidData(String data) {
        return data != null && data.contains("JSON");
    }

    @Override
    protected void processData(String data) {
        System.out.println("Processing JSON data");
    }

    @Override
    protected void saveData(String data) {
        System.out.println("Saving JSON data to database");
    }
}

class DataProcessorDemo {
    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVDataProcessor();
        csvProcessor.process("CSV data");

        System.out.println();

        DataProcessor jsonProcessor = new JSONDataProcessor();
        jsonProcessor.process("XML data");
    }
}

/*
Loading data from CSV file: CSV data
Processing CSV data
Saving CSV data to database

Loading data from JSON file: XML data
Data is invalid, processing aborted.
 */