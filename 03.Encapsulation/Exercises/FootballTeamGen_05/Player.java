package Exercises.FootballTeamGen_05;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        validateStats(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        validateStats(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        validateStats(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        validateStats(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        validateStats(shooting, "Shooting");
        this.shooting = shooting;
    }

    private void validateStats(int value, String type) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(type + " should be between 0 and 100.");
        }
    }

    public double overallSkillLevel() {
        double overallSkill = this.dribble + this.endurance + this.passing + this.shooting + this.sprint;
        return overallSkill / 5;
    }
}
