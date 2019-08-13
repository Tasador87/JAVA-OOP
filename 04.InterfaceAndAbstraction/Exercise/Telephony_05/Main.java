package Exercise.Telephony_05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = Arrays.asList(scanner.nextLine().split("\\s+"));
        List<String> urls = Arrays.asList(scanner.nextLine().split("\\s+"));
        Smartphone callphone = new Smartphone(numbers,urls);

        System.out.println(callphone.call().trim());
        System.out.println(callphone.browse().trim());

    }
}