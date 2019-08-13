package Hardware;

public class HeavyHardware extends Hardware {

    private static final String type = "Heavy";

    public HeavyHardware(String name, int maxCapacity, int maxMemory) {
        super(name, type, maxCapacity, maxMemory);
    }

    @Override
    public void setOperatingCapacity(int operatingCapacity) {
        int newCapacity = operatingCapacity * 2;
        super.setOperatingCapacity(newCapacity);
    }

    @Override
    public void setOperatingMemory(int operatingMemory) {
        int newMemory = operatingMemory - (operatingMemory * 25 / 100);
        super.setOperatingMemory(newMemory);
    }

    @Override
    public void setMaxCapacity(int maxCapacity) {
        int newCapacity = maxCapacity * 2;
        super.setMaxCapacity(newCapacity);
    }

    @Override
    public void setMaxMemory(int maxMemory) {
        int newMemory = maxMemory - (maxMemory * 25 / 100);
        super.setMaxMemory(newMemory);
    }
}
