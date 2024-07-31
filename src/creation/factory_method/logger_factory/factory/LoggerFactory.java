package creation.factory_method.logger_factory.factory;

import creation.factory_method.logger_factory.logger.Logger;

public abstract class LoggerFactory {

    private Logger logger;

    protected abstract Logger createLogger();

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
