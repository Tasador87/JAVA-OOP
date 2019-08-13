package Software;

public class LightSoftware extends Software {

    private static final String type = "Light";

    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, type, capacityConsumption, memoryConsumption);
    }

    @Override
    public void setCapacityConsumption(int capacityConsumption) {
        capacityConsumption = capacityConsumption + (capacityConsumption * 50 / 100);
        super.setCapacityConsumption(capacityConsumption);
    }

    @Override
    public void setMemoryConsumption(int memoryConsumption) {
        memoryConsumption = memoryConsumption - (memoryConsumption * 50 / 100);
        super.setMemoryConsumption(memoryConsumption);
    }
}