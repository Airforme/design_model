public class DatabaseLoggerFactory extends LoggerFactory {
    @Override
    protected Logger createLogger() {
        return new DatabaseLogger();
    }
}
