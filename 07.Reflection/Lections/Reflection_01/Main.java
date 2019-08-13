package Lections.Reflection_01;

public class Main {
    public static void main(String[] args){

        Reflection reflection = new Reflection();
        Class clasA = reflection.getClass();

        System.out.println(clasA);


        System.out.println(clasA.getSuperclass());


        Class[] clasAInterfaces = clasA.getInterfaces();

        for (Class interfacesNames : clasAInterfaces) {
            System.out.println(interfacesNames);
        }

        System.out.println(reflection);

        //можем да създадем истанция(нов обект) на класа и по този начин:
       // Reflection reflection1 = (Reflection) clasA.getConstructor().newInstance();
       // System.out.println(reflection1);
    }
}