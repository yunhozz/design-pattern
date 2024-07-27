package _SOLID._3_liskov_substitution.compliant.area;

public class AreaCalculator {

    public void calculateArea(Shape shape) {
        System.out.println("Area: " + shape.getArea());
    }
}
