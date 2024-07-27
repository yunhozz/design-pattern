package _SOLID._3_liskov_substitution.compliant.bird;

public class Sparrow extends Bird implements Flyable {

    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}
