package Exercises.barracksWars.core.commands;

import Exercises.barracksWars.interfaces.Repository;
import Exercises.barracksWars.interfaces.UnitFactory;

public class Retire extends Command {

    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String result;
        String unitType = this.getData()[1];
        try {
            this.getRepository().removeUnit(unitType);
            result = unitType + " retired!";
        } catch (IllegalArgumentException ex) {
            result = ex.getMessage();
        }

        return result;
    }
}
