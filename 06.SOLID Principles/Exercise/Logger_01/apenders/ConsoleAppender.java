package Exercise.Logger_01.apenders;

import Exercise.Logger_01.Layouts.Layout;
import Exercise.Logger_01.ReportLevel;

public class ConsoleAppender extends AppenderImpl {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String massage) {
        System.out.println(this.format(date, reportLevel, massage));
    }
}