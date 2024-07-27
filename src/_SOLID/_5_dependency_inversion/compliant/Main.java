package _SOLID._5_dependency_inversion.compliant;

import _SOLID._5_dependency_inversion.non_compliant.device.Fan;
import _SOLID._5_dependency_inversion.non_compliant.device.Switch;

public class Main {

    public static void main(String[] args) {
        Fan fan = new Fan();
        Switch device = new Switch(fan);

        device.turnOn(); // Fan is spinning
        device.turnOff(); // Fan is stopping
    }
}
