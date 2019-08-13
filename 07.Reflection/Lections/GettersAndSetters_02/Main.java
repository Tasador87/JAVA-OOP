package Lections.GettersAndSetters_02;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Reflection reflection = new Reflection();

        Class clasA = reflection.getClass();
        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();

        for (Method declaredMethod : clasA.getDeclaredMethods()) {

            if (declaredMethod.getName().startsWith("get")){
                getters.add(declaredMethod);
            }else if (declaredMethod.getName().startsWith("set")){
                setters.add(declaredMethod);
            }
        }

        getters.sort(Comparator.comparing(Method::getName));
        setters.sort(Comparator.comparing(Method::getName));

        for (Method getter : getters) {
            System.out.println(String.format("%s will return class %s",getter.getName(),getter.getReturnType().getName()));
        }

        for (Method setter : setters) {
            System.out.println(String.format("%s and will set field of class %s",setter.getName(),setter.getParameterTypes()[0].getName()));
        }

        //можем да създадем истанция(нов обект) на класа и по този начин:
       // Reflection reflection1 = (Reflection) clasA.getConstructor().newInstance();
       // System.out.println(reflection1);
    }
}