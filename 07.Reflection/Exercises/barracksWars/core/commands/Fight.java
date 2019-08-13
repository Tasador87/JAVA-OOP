package Exercises.barracksWars.core.commands;

import Exercises.barracksWars.interfaces.Repository;
import Exercises.barracksWars.interfaces.UnitFactory;

public class Fight extends Command {


    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
