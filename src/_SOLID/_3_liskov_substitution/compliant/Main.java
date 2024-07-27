package _SOLID._3_liskov_substitution.compliant;

import _SOLID._3_liskov_substitution.compliant.area.AreaCalculator;
import _SOLID._3_liskov_substitution.compliant.area.Rectangle;
import _SOLID._3_liskov_substitution.compliant.area.Shape;
import _SOLID._3_liskov_substitution.compliant.area.Square;
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

        ///////////////////////////////////////////////////

        AreaCalculator calculator = new AreaCalculator();

        // LSP Compliant
        Shape rectangle = new Rectangle(5, 4);
        calculator.calculateArea(rectangle); // Output: Area: 20

        Shape square = new Square(5);
        calculator.calculateArea(square); // Output: Area: 25 (Expected)
    }
}
