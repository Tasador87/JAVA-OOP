package Hardware;

public class PowerHardware extends Hardware {

    private static final String type = "Power";

    public PowerHardware(String name, int maxCapacity, int maxMemory) {
        super(name, type, maxCapacity, maxMemory);
    }

    @Override
    public void setOperatingCapacity(int operatingCapacity) {
        int newCapacity = operatingCapacity - (operatingCapacity * 75 / 100);
        super.setOperatingCapacity(newCapacity);
    }

    @Override
    public void setOperatingMemory(int operatingMemory) {
        int newMemory = operatingMemory + (operatingMemory * 75 / 100);
        super.setOperatingMemory(newMemory);
    }

    @Override
    public void setMaxCapacity(int maxCapacity) {
        int newCapacity = maxCapacity - (maxCapacity * 75 / 100);
        super.setMaxCapacity(newCapacity);
    }

    @Override
    public void setMaxMemory(int maxMemory) {
        int newMemory = maxMemory + (maxMemory * 75 / 100);
        super.setMaxMemory(newMemory);
    }
}
