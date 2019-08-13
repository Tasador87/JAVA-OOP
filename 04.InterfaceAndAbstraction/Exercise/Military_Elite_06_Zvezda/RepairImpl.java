package Exercise.Military_Elite_06_Zvezda;

public class RepairImpl implements Repair {

    private String partName;
    private int hoursWorked;

    public RepairImpl(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getName() {
        return this.partName;
    }

    @Override
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("  Part Name: %s Hours Worked: %d",getName(),getHoursWorked());
    }
}
