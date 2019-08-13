package Hardware;

import Software.Software;

import java.util.ArrayList;
import java.util.List;

public abstract class Hardware {
    private String name;
    private String type;
    private int operatingCapacity;
    private int operatingMemory;
    private int maxCapacity;
    private int maxMemory;
    private List<Software> softwares;

    Hardware(String name, String type, int operatingCapacity, int operatingMemory) {
        this.setName(name);
        this.type = type;
        this.setOperatingCapacity(operatingCapacity);
        this.setOperatingMemory(operatingMemory);
        this.softwares = new ArrayList<Software>();
        this.maxCapacity = 0;
        this.maxMemory = 0;
    }

    public List<Software> getSoftwares() {
        return this.softwares;
    }


    private void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public int getOperatingCapacity() {
        return this.operatingCapacity;
    }

    public void setOperatingCapacity(int operatingCapacity) {
        this.operatingCapacity = operatingCapacity;
    }

    public void setNewCapacity(int newCapacity) {
        this.operatingCapacity = newCapacity;
    }

    public int getOperatingMemory() {
        return this.operatingMemory;
    }

    public void setOperatingMemory(int operatingMemory) {
        this.operatingMemory = operatingMemory;
    }

    public void setNewMemory(int newMemory) {
        this.operatingMemory = newMemory;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = this.maxCapacity + maxCapacity;
    }

    public int getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(int maxMemory) {
        this.maxMemory = this.maxMemory + maxMemory;
    }
}
