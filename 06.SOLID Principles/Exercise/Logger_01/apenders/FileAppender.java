package Exercise.Logger_01.apenders;

import Exercise.Logger_01.Layouts.Layout;
import Exercise.Logger_01.ReportLevel;
import Exercise.Logger_01.customFiles.File;
import Exercise.Logger_01.customFiles.LogFile;

import java.io.IOException;

public class FileAppender extends AppenderImpl {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    public void setFile(File file){
        this.file = file;

    }

    @Override
    public void append(String date, ReportLevel reportLevel, String massage) {
        if (this.file == null){
           // throw new NullPointerException("File reference not set to an instance of an object.");
            try {
                this.setFile(new LogFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String str = this.format(date,reportLevel,massage);
        this.file.appendBuffer(str);
        this.file.write();
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
