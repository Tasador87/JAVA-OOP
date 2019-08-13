package Exercise.Logger_01.apenders;

import Exercise.Logger_01.Layouts.Layout;
import Exercise.Logger_01.ReportLevel;

public abstract class AppenderImpl implements Appender {


    private Layout layout;
    private ReportLevel reportLevel;
    private int countMessages;

    public AppenderImpl(Layout layout) {
        this.layout = layout;
        this.setReportLevel(ReportLevel.INFO);
        this.countMessages = 0;
    }

    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    protected String format(String date, ReportLevel reportLevel, String message) {
        this.countMessages++;
        return this.layout.format(date, reportLevel, message);
    }

    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d"
                , this.getClass().getSimpleName(), this.layout.getClass().getSimpleName(), this.reportLevel.toString(), this.countMessages);
    }
}
