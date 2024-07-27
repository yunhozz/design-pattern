package _SOLID._3_liskov_substitution.non_compliant;

import _SOLID._3_liskov_substitution.non_compliant.area.AreaCalculator;
import _SOLID._3_liskov_substitution.non_compliant.area.Rectangle;
import _SOLID._3_liskov_substitution.non_compliant.bird.Bird;
import _SOLID._3_liskov_substitution.non_compliant.bird.Penguin;

public class Main {

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly(); // Bird is flying

        Bird penguin = new Penguin();
        penguin.fly();
        // Throws UnsupportedOperationException

        ////////////////////////////////////////////////////

        AreaCalculator calculator = new AreaCalculator();
        Rectangle rectangle = new Rectangle();
        calculator.calculateArea(rectangle);
        // Expected output for Rectangle: Area: 20
        // Actual output for Square: Area: 16 (LSP violation)
    }
}
