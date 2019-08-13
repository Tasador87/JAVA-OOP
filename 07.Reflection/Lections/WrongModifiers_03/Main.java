package Lections.WrongModifiers_03;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Class reflection = Reflection.class;

        Method[] methods = reflection.getDeclaredMethods();
        List<Field> fields = Arrays.asList(reflection.getDeclaredFields());

        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();


        for (Method method : methods) {
            if (method.getName().startsWith("get")) {
                getters.add(method);
            } else if (method.getName().startsWith("set")) {
                setters.add(method);
            }
        }

        getters.sort(Comparator.comparing(Method::getName));
        setters.sort(Comparator.comparing(Method::getName));
        fields.sort(Comparator.comparing(Field::getName));


        for (Field field : fields) {
            if (!Modifier.isPrivate(field.getModifiers())) {
                System.out.println(String.format("%s must be private!", field.getName()));
            }
        }

        for (Method getter : getters) {
            if (!Modifier.isPublic(getter.getModifiers())){
                System.out.println(String.format("%s have to be public!",getter.getName()));
            }
        }

        for (Method setter : setters) {
            if (!Modifier.isPrivate(setter.getModifiers())){
                System.out.println(String.format("%s must be private!", setter.getName()));
            }
        }
    }
}
