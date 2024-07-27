package _SOLID._5_dependency_inversion.compliant.device;

// High-level class
public class Switch {

    private final Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void turnOn() {
        device.turnOn();
    }

    public void turnOff() {
        device.turnOff();
    }
}