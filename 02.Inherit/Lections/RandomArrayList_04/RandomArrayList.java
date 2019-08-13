package Lections.RandomArrayList_04;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    Random random = new Random();

    public Object getRandomElement(){
        int index = random.nextInt(super.size());
        return super.remove(index);
    }
}
