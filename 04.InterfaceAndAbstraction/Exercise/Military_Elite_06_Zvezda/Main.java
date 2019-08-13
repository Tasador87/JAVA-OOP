package Exercise.Military_Elite_06_Zvezda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Private> soldiers = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");

            int id = Integer.parseInt(data[1]);
            String firstName = data[2];
            String lastName = data[3];

            if (data[0].equals("Private")) {     // "Private <id> <firstName> <lastName> <salary>"
                double salary = Double.parseDouble(data[4]);
                Private soldier = new PrivateImpl(id, firstName, lastName, salary);
                System.out.println(soldier.toString());
                soldiers.add(soldier);

            } else if (data[0].equals("LeutenantGeneral")) {   //"LieutenantGeneral <id> <firstName> <lastName> <salary> <private1Id> <private2Id>
                double salary = Double.parseDouble(data[4]);
                LieutenantGeneral general = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                if (data.length > 5) {
                    for (int i = 5; i < data.length; i++) {
                        for (Private soldier : soldiers) {
                            if (Integer.parseInt(data[i]) == (soldier.getId())) {
                                general.addPrivate(soldier);
                            }
                        }
                    }
                }
                System.out.println(general.toString());

            } else if (data[0].equals("Engineer")) {   //"Engineer <id> <firstName> <lastName> <salary> <corps> <repair1Part> <repair1Hours> …
                double salary = Double.parseDouble(data[4]);
                if (data[5].equals("Airforces") || data[5].equals("Marines")) {
                    String corps = data[5];
                    Engineer engineer = new EngineerImpl(id, firstName, lastName, salary, Corps.valueOf(corps));
                    if (data.length > 6) {
                        for (int i = 6; i < data.length - 1; i += 2) {
                            Repair repair = new RepairImpl(data[i], Integer.parseInt(data[i + 1]));
                            engineer.addRepair(repair);
                        }
                    }
                    System.out.println(engineer.toString());
                }

            } else if (data[0].equals("Commando")) {  //"Commando <id> <firstName> <lastName> <salary> <corps> <mission1CodeName> <mission1state> …
                double salary = Double.parseDouble(data[4]);

                if (data[5].equals("Airforces") || data[5].equals("Marines")) {
                    String corps = data[5];
                    Commando commando = new CommandoImpl(id, firstName, lastName, salary, Corps.valueOf(corps));
                    if (data.length > 6) {
                        for (int i = 6; i < data.length - 1; i += 2) {
                            if (data[i + 1].equals("Finished") || data[i + 1].equals("inProgress")) {
                                String state = data[i + 1];
                                Mission mission = new MissionImpl(data[i], State.valueOf(state));
                                commando.addMission(mission);
                            }
                        }
                    }
                    System.out.println(commando.toString());
                }

            } else if (data[0].equals("Spy")) {   //"Spy <id> <firstName> <lastName> <codeNumber>"
                String codeNumber = data[4];
                Spy spy = new SpyImpl(id, firstName, lastName, codeNumber);
                System.out.println(spy.toString());
            }
            input = scanner.nextLine();
        }
    }
}