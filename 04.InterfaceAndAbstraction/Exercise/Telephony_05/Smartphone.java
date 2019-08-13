package Exercise.Telephony_05;

import java.util.List;

public class Smartphone implements Browsable, Callable {
    List<String> numbers;
    List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : this.urls) {

            if (url.matches("(\\D+)")){
                sb.append("Browsing: " + url + "!");
                sb.append(System.lineSeparator());

            }else {
                sb.append("Invalid URL!");
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();

        for (String number : numbers) {
            if (number.matches("(\\d+)")) {
                sb.append("Calling... " + number);
                sb.append(System.lineSeparator());
            }else{
                sb.append("Invalid number!");
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}