package Software;

public class ExpressSoftware extends Software {

    private static final String type = "Express";

    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, type, capacityConsumption, memoryConsumption);
    }

    @Override
    public void setMemoryConsumption(int memoryConsumption) {
        super.setMemoryConsumption(memoryConsumption * 2);
    }
}
