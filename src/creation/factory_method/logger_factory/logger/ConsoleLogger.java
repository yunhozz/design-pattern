package creation.factory_method.logger_factory.logger;

public class ConsoleLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("Console : " + message);
    }
}
