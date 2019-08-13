package Exercises.FootballTeamGen_05;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Team> teams = new LinkedHashMap<>();


        while (!input.equals("END")) {
            String[] commands = input.split(";");
            String command = commands[0];
            try {

                if (command.equals("Team")) {
                    if (!teams.containsKey(commands[1])) {
                        teams.put(commands[1], new Team(commands[1]));
                    }

                } else if (command.equals("Add")) {
                    if (teams.containsKey(commands[1])) {
                        Player player = new Player(commands[2], Integer.parseInt(commands[3]),
                                Integer.parseInt(commands[4]),
                                Integer.parseInt(commands[5]),
                                Integer.parseInt(commands[6]),
                                Integer.parseInt(commands[7]));
                        teams.get(commands[1]).addPlayer(player);
                    } else {
                        System.out.println("Team " + commands[1] + " does not exist.");
                    }

                } else if (command.equals("Remove")) {
                    if (teams.get(commands[1]).getPlayers().stream().anyMatch(player -> player.getName().equals(commands[2]))) {
                        teams.get(commands[1]).removePlayer(commands[2]);
                    } else {
                        System.out.println("Player " + commands[2] + " is not in " + commands[1] + " team.");
                    }

                } else if (command.equals("Rating")) {
                    if (teams.containsKey(commands[1])) {
                        System.out.println(commands[1] + " - " + Math.round(teams.get(commands[1]).getRating()));
                    } else {
                        System.out.println("Team " + commands[1] + " does not exist.");
                    }
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            input = scanner.nextLine();
        }

    }
}
