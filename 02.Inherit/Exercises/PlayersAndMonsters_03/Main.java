package Exercises.PlayersAndMonsters_03;

import Exercises.PlayersAndMonsters_03.hero.DarkKnight;
import Exercises.PlayersAndMonsters_03.hero.DarkWizard;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DarkKnight darkKnight = new DarkKnight("Dartanqn", 22);
        DarkWizard darkWizard = new DarkWizard("Morgana", 23);

        System.out.println(darkKnight.toString());
        System.out.println(darkWizard.toString());
    }
}