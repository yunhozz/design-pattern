package creation.factory_method.logger_factory.factory;

import creation.factory_method.logger_factory.logger.ConsoleLogger;
import creation.factory_method.logger_factory.logger.Logger;

public class ConsoleLoggerFactory extends LoggerFactory {

    @Override
    protected Logger createLogger() {
        return new ConsoleLogger();
    }
}
