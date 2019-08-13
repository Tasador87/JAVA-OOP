package Lections.RandomArrayList_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RandomArrayList randomArrayList = new RandomArrayList();

        randomArrayList.add("123");
        randomArrayList.add(111);
        randomArrayList.add("Pesho");
        randomArrayList.add("Pesho2");

        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
    }
}
