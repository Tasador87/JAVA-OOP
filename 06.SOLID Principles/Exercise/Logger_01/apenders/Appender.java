package Exercise.Logger_01.apenders;

import Exercise.Logger_01.ReportLevel;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String massage);
    ReportLevel getReportLevel();
    void setReportLevel(ReportLevel reportLevel);
}
