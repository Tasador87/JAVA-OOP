package Lections.BorderControl_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Identifiable> citizens = new ArrayList<>();

        while (!input.equals("End")){
            String[] data = input.split("\\s+");
            if (data.length == 2){
                String model = data[0];
                String idRobot = data[1];
                Identifiable robot = new Robot(model,idRobot);
                citizens.add(robot);
            }else{
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];
                Identifiable human = new Citizen(name,age,id);
                citizens.add(human);
            }
            input = scanner.nextLine();
        }
        String endsId = scanner.nextLine();
        for (Identifiable citizen : citizens) {
            if (citizen.getId().endsWith(endsId)){
                System.out.println(citizen.getId());
            }
        }
    }
}
