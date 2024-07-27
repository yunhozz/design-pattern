package _SOLID._5_dependency_inversion.non_compliant.device;

// High-level class
public class Switch {

    private final Fan fan;

    public Switch(Fan fan) {
        this.fan = fan;
    }

    public void turnOn() {
        fan.spin();
    }

    public void turnOff() {
        fan.stop();
    }
}
