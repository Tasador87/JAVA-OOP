package Exercise.Logger_01.Layouts;

import Exercise.Logger_01.ReportLevel;

public class SimpleLayout implements Layout {

    @Override
    public String format(String date, ReportLevel reportLevel, String massage) {
        //format must be: "<date-time> - <report level> - <message>"
        return String.format("%s - %s - %s", date, reportLevel.toString(), massage);
    }
}
