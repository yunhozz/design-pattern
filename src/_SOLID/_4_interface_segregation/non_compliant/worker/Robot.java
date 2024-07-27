package _SOLID._4_interface_segregation.non_compliant.worker;

public class Robot implements Worker {

    @Override
    public void work() {
        System.out.println("Robot is working");
    }

    @Override
    public void eat() {
        // Robots do not eat
        throw new UnsupportedOperationException("Robots do not eat");
    }
}
