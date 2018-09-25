package cs544.flight.logging;

public interface ISystemLogger {
    public void info(String log);
    public void warning(String log);
    public void error(String log);
    public void debug(String log);
}
