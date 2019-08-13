package Exercise.Military_Elite_06_Zvezda;

public class SpyImpl extends SoldierImpl implements Spy {
    private String codeNumber;

    protected SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Code Number: ").append(getCodeNumber()).append(System.lineSeparator());
        return sb.toString().trim();
    }
}