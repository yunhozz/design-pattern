package _SOLID._3_liskov_substitution.compliant;

import _SOLID._3_liskov_substitution.compliant.bird.Bird;
import _SOLID._3_liskov_substitution.compliant.bird.Flyable;
import _SOLID._3_liskov_substitution.compliant.bird.Penguin;
import _SOLID._3_liskov_substitution.compliant.bird.Sparrow;

public class Main {

    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        sparrow.eat(); // Bird is eating
        ((Flyable) sparrow).fly(); // Sparrow is flying

        Bird penguin = new Penguin();
        penguin.eat(); // Bird is eating
        ((Flyable) penguin).fly(); // Compilation error, Penguin is not Flyable
    }
}
