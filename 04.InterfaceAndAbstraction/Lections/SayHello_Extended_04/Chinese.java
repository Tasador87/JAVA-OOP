package Lections.SayHello_Extended_04;

public class Chinese extends BasePerson  implements Person{

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
