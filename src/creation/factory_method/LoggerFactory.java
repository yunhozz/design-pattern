package creation.factory_method;

// Logger interface
interface Logger {
    void log(String message);
}

// Concrete loggers
class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("Console: " + message);
    }
}

class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("File: " + message);
        // In a real scenario, this would write to a file
    }
}

// Abstract creator
abstract class LoggerFactory {
    private Logger logger;

    // Factory method
    protected abstract Logger createLogger();

    // Get logger instance (implement singleton pattern)
    public Logger getLogger() {
        if (logger == null) {
            logger = createLogger();
        }
        return logger;
    }

    public void logMessage(String message) {
        getLogger().log(message);
    }
}

// Concrete creators
class ConsoleLoggerFactory extends LoggerFactory {
    @Override
    protected Logger createLogger() {
        return new ConsoleLogger();
    }
}

class FileLoggerFactory extends LoggerFactory {
    @Override
    protected Logger createLogger() {
        return new FileLogger();
    }
}

class LoggerFactoryDemo {
    public static void main(String[] args) {
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