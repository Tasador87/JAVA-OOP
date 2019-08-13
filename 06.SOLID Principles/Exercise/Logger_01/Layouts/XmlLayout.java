package Exercise.Logger_01.Layouts;

import Exercise.Logger_01.ReportLevel;

public class XmlLayout implements Layout {
    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("<log>%n" +
                "   <date>%s</date>%n" +
                "   <level>%s</level>%n" +
                "   <message>%s</message>%n" +
                "</log>%n", date, reportLevel, message);
    }
}