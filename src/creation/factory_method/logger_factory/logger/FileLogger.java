package creation.factory_method.logger_factory.logger;

public class FileLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println("File : " + message);
    }
}
