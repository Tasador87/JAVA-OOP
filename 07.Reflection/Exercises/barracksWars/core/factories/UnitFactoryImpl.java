package Exercises.barracksWars.core.factories;

import Exercises.barracksWars.interfaces.Unit;
import Exercises.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME = "Exercises.barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {

        Unit unit = null;

        try {
            if (unitType.equals(Class.forName(UNITS_PACKAGE_NAME + unitType).getSimpleName())) {

                Class units = Class.forName(UNITS_PACKAGE_NAME + unitType);

                unit = (Unit) units.getConstructor().newInstance();
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return unit;

//		if (unitType.equals(Archer.class.getSimpleName())){
//			unit = new Archer();
//		}else if (unitType.equals(Pikeman.class.getSimpleName())){
//			unit = new Pikeman();
//		}else if (unitType.equals(Swordsman.class.getSimpleName())){
//			unit = new Swordsman();
//		}else if (unitType.equals(Horseman.class.getSimpleName())){
//			unit = new Horseman();
//		}else if (unitType.equals(Gunner.class.getSimpleName())){
//			unit = new Gunner();
//		}
    }
}
