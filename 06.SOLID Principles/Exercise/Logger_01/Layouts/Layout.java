package Exercise.Logger_01.Layouts;

import Exercise.Logger_01.ReportLevel;

public interface Layout {
    String format(String date, ReportLevel reportLevel, String massage);
}
