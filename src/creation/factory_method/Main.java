package creation.factory_method;

import creation.factory_method.logger_factory.factory.ConsoleLoggerFactory;
import creation.factory_method.logger_factory.factory.FileLoggerFactory;
import creation.factory_method.logger_factory.factory.LoggerFactory;
import creation.factory_method.vehicle_factory.factory.CarFactory;
import creation.factory_method.vehicle_factory.factory.MotorcycleFactory;
import creation.factory_method.vehicle_factory.factory.VehicleFactory;

public class Main {

    public static void main(String[] args) {
        vehicleFactory();
        System.out.println("\n----------------------\n");
        loggerFactory();
    }

    private static void vehicleFactory() {
        VehicleFactory carFactory = new CarFactory();
        carFactory.deliverVehicle();

        VehicleFactory motorcycleFactory = new MotorcycleFactory();
        motorcycleFactory.deliverVehicle();
    }

    private static void loggerFactory() {
        LoggerFactory consoleFactory = new ConsoleLoggerFactory();
        LoggerFactory fileFactory = new FileLoggerFactory();

        // Using console logger
        consoleFactory.logMessage("This is a console log message.");
        consoleFactory.logMessage("Another console log message.");

        // Using file logger
        fileFactory.logMessage("This is a file log message.");
        fileFactory.logMessage("Another file log message.");
    }
}
