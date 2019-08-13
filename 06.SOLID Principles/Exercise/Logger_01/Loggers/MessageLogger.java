package Exercise.Logger_01.Loggers;

import Exercise.Logger_01.ReportLevel;
import Exercise.Logger_01.apenders.Appender;

public class MessageLogger implements Logger {

    private Appender[] appenders;

    public MessageLogger(Appender... args) {
        this.appenders = args;
    }

    @Override
    public void logError(String date, String message) {
        logMessage(date, ReportLevel.ERROR, message);
    }

    @Override
    public void logWarning(String date, String message) {
        logMessage(date, ReportLevel.WARNING, message);
    }

    @Override
    public void logInfo(String date, String message) {
        logMessage(date, ReportLevel.INFO, message);
    }

    @Override
    public void logFatal(String date, String message) {
        logMessage(date, ReportLevel.FATAL, message);
    }

    @Override
    public void logCritical(String date, String message) {
       logMessage(date, ReportLevel.CRITICAL, message);
    }

    public void logMessage(String date, ReportLevel reportLevel, String message) {
        for (Appender appender : appenders) {

            if (appender.getReportLevel().compareTo(reportLevel) <= 0) {
                appender.append(date, reportLevel, message);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Logger info").append(System.lineSeparator());
        for (Appender appender : appenders) {
            sb.append(appender.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
