package _SOLID._3_liskov_substitution.non_compliant.area;

public class Square extends Rectangle {

    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    @Override
    public void setHeight(int height) {
        this.width = height;
        this.height = height;
    }

    @Override
    public int getArea() {
        return super.getArea();
    }
}
