package Exercise;

import Exercise.Logger_01.Layouts.Layout;
import Exercise.Logger_01.Layouts.SimpleLayout;
import Exercise.Logger_01.Layouts.XmlLayout;
import Exercise.Logger_01.Loggers.Logger;
import Exercise.Logger_01.Loggers.MessageLogger;
import Exercise.Logger_01.ReportLevel;
import Exercise.Logger_01.apenders.Appender;
import Exercise.Logger_01.apenders.ConsoleAppender;
import Exercise.Logger_01.apenders.FileAppender;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int index = 0;

        Appender[] appenders = new Appender[n];

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            Appender appender = null;
            Layout layout = null;

            if (data[1].equals("SimpleLayout")) {
                layout = new SimpleLayout();
            } else {
                layout = new XmlLayout();
            }

            if (data[0].equals("ConsoleAppender")) {
                appender = new ConsoleAppender(layout);
            } else {
                appender = new FileAppender(layout);
            }

            if (data.length == 3) {
                appender.setReportLevel(ReportLevel.valueOf(data[2]));
            }
            appenders[index++] = appender;
        }
        Logger logger = new MessageLogger(appenders);

        String line = scanner.nextLine();

        while (!line.equals("END")) {

            String[] data = line.split("\\|");

            switch (ReportLevel.valueOf(data[0])) {
                case ERROR:
                    logger.logError(data[1], data[2]);
                    break;
                case CRITICAL:
                    logger.logCritical(data[1], data[2]);
                    break;
                case FATAL:
                    logger.logFatal(data[1], data[2]);
                    break;
                case INFO:
                    logger.logInfo(data[1], data[2]);
                    break;
                case WARNING:
                    logger.logWarning(data[1], data[2]);
                    break;
            }

            line = scanner.nextLine();
        }
        System.out.println(logger.toString());
    }
}