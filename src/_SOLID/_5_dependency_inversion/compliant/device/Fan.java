package _SOLID._5_dependency_inversion.compliant.device;

// Low-level class implementing the interface
public class Fan implements Switchable {

    @Override
    public void turnOn() {
        System.out.println("Fan is spinning");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan is stopping");
    }
}
