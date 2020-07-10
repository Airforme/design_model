public abstract class LoggerFactory {
    protected abstract Logger createLogger();

    public void writeLog() {
        Logger logger = this.createLogger();
        logger.witerLog();
    }
}
