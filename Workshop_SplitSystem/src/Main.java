import Commands.Commands;
import Commands.CommandsImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Commands hardwares = new CommandsImpl();

        String inputData = scanner.nextLine();

        while (!inputData.equals("System Split")) {

            String[] commands = inputData.split("\\(");
            String command = commands[0];
            String[] values = commands[1].split("[, ] |[\\)]");

            if (command.equals("RegisterPowerHardware")) {
                String name = values[0];
                int capacity = Integer.parseInt(values[1]);
                int memory = Integer.parseInt(values[2]);
                hardwares.registerPowerHardware(name, capacity, memory);

            } else if (command.equals("RegisterHeavyHardware")) {
                String name = values[0];
                int capacity = Integer.parseInt(values[1]);
                int memory = Integer.parseInt(values[2]);
                hardwares.registerHeavyHardware(name, capacity, memory);

            } else if (command.equals("RegisterLightSoftware")) {
                String hardwareName = values[0];
                String softwareName = values[1];
                int capacity = Integer.parseInt(values[2]);
                int memory = Integer.parseInt(values[3]);
                hardwares.registerLightSoftware(hardwareName, softwareName, capacity, memory);

            } else if (command.equals("RegisterExpressSoftware")) {
                String hardwareName = values[0];
                String softwareName = values[1];
                int capacity = Integer.parseInt(values[2]);
                int memory = Integer.parseInt(values[3]);
                hardwares.registerExpressSoftware(hardwareName, softwareName, capacity, memory);

            } else if (command.equals("ReleaseSoftwareComponent")) {
                String hardwareName = values[0];
                String softwareName = values[1];
                hardwares.releaseSoftware(hardwareName, softwareName);

            } else if (command.equals("Analyze")) {
                System.out.println(hardwares.analyze());
            }else if (command.equals("Dump")) {
                String hardwareName = values[0];
                hardwares.dump(hardwareName);
            }else if (command.equals("Restore")){
                String hardwareName = values[0];
                hardwares.restore(hardwareName);
            }else if (command.equals("Destroy")){
                String hardwareName = values[0];
                hardwares.destroy(hardwareName);
            }else if (command.equals("DumpAnalyze")){
                hardwares.dumpAnalyze();
            }

            inputData = scanner.nextLine();
        }
            hardwares.systemSplit();
    }
}