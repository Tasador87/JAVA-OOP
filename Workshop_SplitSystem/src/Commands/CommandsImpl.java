package Commands;

import Hardware.*;
import Software.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CommandsImpl implements Commands {

    private Map<String, Hardware> hardwares;
    private Map<String, Hardware> dumpHardwares;

    public CommandsImpl() {
        this.hardwares = new LinkedHashMap<>();
        this.dumpHardwares = new LinkedHashMap<>();
    }

    @Override
    public void registerPowerHardware(String name, int capacity, int memory) {
        Hardware powerHardware = new PowerHardware(name, capacity, memory);
        this.hardwares.put(name, powerHardware);
        powerHardware.setMaxMemory(memory);
        powerHardware.setMaxCapacity(capacity);
    }

    @Override
    public void registerHeavyHardware(String name, int capacity, int memory) {
        Hardware heavyHardware = new HeavyHardware(name, capacity, memory);
        this.hardwares.put(name, heavyHardware);
        heavyHardware.setMaxCapacity(capacity);
        heavyHardware.setMaxMemory(memory);
    }

    @Override
    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        Software software = new ExpressSoftware(name, capacity, memory);
        isEnoughCapacityOrMemory(hardwareComponentName, capacity, memory, software);
    }

    @Override
    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        Software software = new LightSoftware(name, capacity, memory);
        isEnoughCapacityOrMemory(hardwareComponentName, capacity, memory, software);
    }

    private void isEnoughCapacityOrMemory(String hardwareComponentName, int capacity, int memory, Software software) {
        int hardwareMemory = this.hardwares.get(hardwareComponentName).getOperatingMemory();
        int hardwareCapacity = this.hardwares.get(hardwareComponentName).getOperatingCapacity();

        if (this.hardwares.containsKey(hardwareComponentName)) {
            if (hardwareMemory >= memory || hardwareCapacity >= capacity) {
                this.hardwares.get(hardwareComponentName).getSoftwares().add(software);
                this.hardwares.get(hardwareComponentName).setNewMemory(hardwareMemory - memory);
                this.hardwares.get(hardwareComponentName).setNewCapacity(hardwareCapacity - capacity);
            }
        }
    }

    public void releaseSoftware(String hardwareName, String softwareName) {
        if (this.hardwares.containsKey(hardwareName)) {
            //this.hardwares.get(hardwareName).getSoftwares().removeIf(e -> e.getName().equals(softwareName));  -> can be replaced with this!
            List<Software> softwares = this.hardwares.get(hardwareName).getSoftwares();
            int index = -1;
            for (int i = 0; i < softwares.size(); i++) {
                if (softwares.get(i).getName().equals(softwareName)) {
                    index = i;
                }
            }

            if (index != -1) {
                int hardwareMemory = this.hardwares.get(hardwareName).getOperatingMemory();
                int hardwareCapacity = this.hardwares.get(hardwareName).getOperatingCapacity();
                int softwareMemory = this.hardwares.get(hardwareName).getSoftwares().get(index).getMemoryConsumption();
                int softwareCapacity = this.hardwares.get(hardwareName).getSoftwares().get(index).getCapacityConsumption();

                this.hardwares.get(hardwareName).setNewMemory(hardwareMemory + softwareMemory);
                this.hardwares.get(hardwareName).setNewCapacity(hardwareCapacity + softwareCapacity);
                softwares.remove(index);
            }
        }
    }

    public void dump(String hardwareName) {
        if (hardwares.containsKey(hardwareName)) {
            dumpHardwares.put(hardwareName, hardwares.get(hardwareName));
            hardwares.remove(hardwareName);
        }
    }

    public void restore(String hardwareName) {
        if (dumpHardwares.containsKey(hardwareName)) {
            hardwares.put(hardwareName, dumpHardwares.get(hardwareName));
            dumpHardwares.remove(hardwareName);
        }
    }

    public void destroy(String hardwareName) {
        dumpHardwares.remove(hardwareName);
    }

    public Map<String, Hardware> getHardwares() {
        return this.hardwares;
    }

    public void dumpAnalyze() {
        System.out.println("Dump Analysis");
        System.out.println(String.format("Power Hardware Components: %d", dumpHardwares.values().stream().filter(h -> h.getType().equals("Power")).count()));
        System.out.println(String.format("Heavy Hardware Components: %d", dumpHardwares.values().stream().filter(h -> h.getType().equals("Heavy")).count()));

        AtomicInteger express = new AtomicInteger();
        AtomicInteger light = new AtomicInteger();
        dumpHardwares.values().forEach(e -> express.addAndGet((int) e.getSoftwares().stream().filter(s -> s.getType().equals("Express")).count()));
        dumpHardwares.values().forEach(e -> light.addAndGet((int) e.getSoftwares().stream().filter(s -> s.getType().equals("Light")).count()));

        AtomicInteger memoryConsumption = new AtomicInteger();
        AtomicInteger capacityConsumption = new AtomicInteger();
        dumpHardwares.values().forEach(e -> e.getSoftwares().forEach(s -> memoryConsumption.addAndGet(s.getMemoryConsumption())));
        dumpHardwares.values().forEach(e -> e.getSoftwares().forEach(s -> capacityConsumption.addAndGet(s.getCapacityConsumption())));

        System.out.println(String.format("Express Software Components: %s", express));
        System.out.println(String.format("Light Software Components: %s", light));
        System.out.println(String.format("Total Dumped Memory: %s", memoryConsumption));
        System.out.println(String.format("Total Dumped Capacity: %s", capacityConsumption));
    }

    public String analyze() {
        int softwareCounts = hardwares.values().stream().mapToInt(e -> e.getSoftwares().size()).sum();

        AtomicInteger memoryConsumption = new AtomicInteger();
        AtomicInteger capacityConsumption = new AtomicInteger();
        hardwares.values().forEach(e -> e.getSoftwares().forEach(s -> memoryConsumption.addAndGet(s.getMemoryConsumption())));
        hardwares.values().forEach(e -> e.getSoftwares().forEach(s -> capacityConsumption.addAndGet(s.getCapacityConsumption())));

        AtomicInteger totalMemory = new AtomicInteger();
        AtomicInteger totalCapacity = new AtomicInteger();
        hardwares.values().forEach(e -> totalMemory.addAndGet(e.getMaxMemory()));
        hardwares.values().forEach(e -> totalCapacity.addAndGet(e.getMaxCapacity()));

        return "System Analysis" + System.lineSeparator() +
                "Hardware Components: " + hardwares.size() + System.lineSeparator() +
                "Software Components: " + softwareCounts + System.lineSeparator() +
                String.format("Total Operational Memory: %s / %s", memoryConsumption, totalMemory) + System.lineSeparator() +
                String.format("Total Capacity Taken: %s / %s", capacityConsumption, totalCapacity);
    }

    public void systemSplit() {
        hardwares.entrySet().stream().sorted((a, b) -> b.getValue().getType().compareTo(a.getValue().getType())).forEach(e -> {
            System.out.println(String.format("Hardware Component - %s", e.getKey()));
            System.out.println(String.format("Express Software Components - %d", e.getValue().getSoftwares().stream().filter(s -> s.getType().equals("Express")).count()));
            System.out.println(String.format("Light Software Components - %d", e.getValue().getSoftwares().stream().filter(s -> s.getType().equals("Light")).count()));
            System.out.println(String.format("Memory Usage: %d / %d", e.getValue().getSoftwares().stream().mapToInt(s -> s.getMemoryConsumption()).sum(), e.getValue().getMaxMemory()));
            System.out.println(String.format("Capacity Usage: %d / %d", e.getValue().getSoftwares().stream().mapToInt(s -> s.getCapacityConsumption()).sum(), e.getValue().getMaxCapacity()));
            System.out.println("Type: " + e.getValue().getType());
            System.out.print("Software Components: ");
            if (e.getValue().getSoftwares().size() > 0) {
                for (int i = 0; i < e.getValue().getSoftwares().size(); i++) {
                    String name = e.getValue().getSoftwares().get(i).getName();
                    if (i == e.getValue().getSoftwares().size() - 1) {
                        System.out.printf("%s%n", name);
                    } else {
                        System.out.print(name + ", ");
                    }
                }
            } else {
                System.out.printf("None%n");
            }
        });
    }
}