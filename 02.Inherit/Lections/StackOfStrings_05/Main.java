package Lections.StackOfStrings_05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StackOfStrings stack = new StackOfStrings();

        stack.push("123");
        stack.push("234");
        stack.push("345");
        stack.push("678");

        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
