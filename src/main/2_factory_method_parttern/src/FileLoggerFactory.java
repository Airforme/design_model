public class FileLoggerFactory extends LoggerFactory {
    @Override
    protected Logger createLogger() {
        return new FileLogger();
    }
}
