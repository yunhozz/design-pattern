package creation.factory_method.logger_factory.factory;

import creation.factory_method.logger_factory.logger.FileLogger;
import creation.factory_method.logger_factory.logger.Logger;

public class FileLoggerFactory extends LoggerFactory {

    @Override
    protected Logger createLogger() {
        return new FileLogger();
    }
}
