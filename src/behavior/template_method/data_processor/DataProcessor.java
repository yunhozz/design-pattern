package behavior.template_method.data_processor;

public abstract class DataProcessor {

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