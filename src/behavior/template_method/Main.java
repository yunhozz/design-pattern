package behavior.template_method;

import behavior.template_method.beverage.Beverage;
import behavior.template_method.beverage.Coffee;
import behavior.template_method.beverage.Tea;
import behavior.template_method.data_processor.CSVDataProcessor;
import behavior.template_method.data_processor.DataProcessor;
import behavior.template_method.data_processor.JSONDataProcessor;

public class Main {

    public static void main(String[] args) {
        makeBeverage();
        System.out.println("\n------------------------------\n");
        processData();
    }

    private static void makeBeverage() {
        Beverage tea = new Tea();
        Beverage coffee = new Coffee();

        System.out.println("Making tea...");
        tea.prepareRecipe();

        System.out.println();

        System.out.println("Making coffee...");
        coffee.prepareRecipe();
    }

    private static void processData() {
        DataProcessor csvProcessor = new CSVDataProcessor();
        csvProcessor.process("CSV data");

        System.out.println();

        DataProcessor jsonProcessor = new JSONDataProcessor();
        jsonProcessor.process("XML data"); // Data is invalid, processing aborted.
    }
}
