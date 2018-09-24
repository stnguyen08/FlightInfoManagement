package cs544.flight.logging;

import java.util.logging.Logger;

public class SystemLogger implements ISystemLogger {
    private static Logger logger; // = Logger.getLogger(LOGGER);

    private static SystemLogger ourInstance = new SystemLogger();

    public static SystemLogger getLogger(String loggerName) {
        ourInstance.setLoggerName(loggerName);
        return ourInstance;

    }

    private SystemLogger() {
    }

    private static void setLoggerName(String loggerName) {
        if(loggerName == null || loggerName.isEmpty()) {
            logger = Logger.getLogger(SystemLogger.class.getName());
        } else {
            logger = Logger.getLogger(loggerName);
        }
    }

    @Override
    public void info(String log) {
        logger.info("INFO: " + log);
    }

    @Override
    public void warning(String log) {
        logger.warning("WARNING: " + log);
    }

    @Override
    public void error(String log) {
        logger.fine("ERROR: " + log);
    }

    @Override
    public void debug(String log) {
        logger.finer("DEBUG: " + log);
    }
}
