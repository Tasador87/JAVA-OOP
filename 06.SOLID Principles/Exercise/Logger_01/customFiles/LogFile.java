package Exercise.Logger_01.customFiles;

import java.io.FileWriter;
import java.io.IOException;

public class LogFile implements File {

    private StringBuilder buffer;
    private FileWriter file;

    public LogFile() throws IOException {
        this.buffer = new StringBuilder();
        this.file = new FileWriter(System.getProperty("user.dir") + "\\Output.txt");
    }

    @Override
    public void write() {
        try {
            this.file = new FileWriter(System.getProperty("user.dir") + "\\Output.txt");
            String text = buffer.toString();
            this.file.append(text);
            this.file.close();
           // this.buffer = new StringBuilder();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void appendBuffer(String text){
        this.buffer.append(text).append(System.lineSeparator());
    }

    @Override
    public int getSize() {
        int size = 0;

        for (char c : this.buffer.toString().toCharArray()) {
            if (Character.isAlphabetic(c)){
                size += c;
            }
        }
        return size;
    }
}
