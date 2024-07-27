package _SOLID._3_liskov_substitution.non_compliant.bird;

public class Penguin extends Bird {

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins cannot fly");
    }
}
