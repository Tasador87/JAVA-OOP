package Exercises.barracksWars.core.commands;

import Exercises.barracksWars.interfaces.Repository;
import Exercises.barracksWars.interfaces.Unit;
import Exercises.barracksWars.interfaces.UnitFactory;

public class Add extends Command {

    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
