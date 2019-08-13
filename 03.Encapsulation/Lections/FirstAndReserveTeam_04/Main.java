package Lections.FirstAndReserveTeam_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] names = reader.readLine().split("\\s+");
            try {
                people.add(new Person(names[0], names[1], Integer.parseInt(names[2]),Double.parseDouble(names[3])));
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

//        people.sort((f, s) -> {
//            int comp = f.getFirstName().compareTo(s.getFirstName());
//            if (comp != 0) {
//                return comp;
//            } else {
//                return Integer.compare(f.getAge(), s.getAge());
//            }
//        });

        Team team = new Team("Black Eagles");


        for (Person player : people) {
            team.addPlayer(player);
        }
        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeam().size() + " players");
    }
}