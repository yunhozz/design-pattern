package _SOLID._3_liskov_substitution.non_compliant.area;

public class AreaCalculator {

    public void calculateArea(Rectangle rectangle) {
        rectangle.setWidth(5);
        rectangle.setHeight(4);
        System.out.println("Area: " + rectangle.getArea());
    }
}
