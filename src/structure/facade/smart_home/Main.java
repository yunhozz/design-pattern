package structure.facade.smart_home;

import structure.facade.smart_home.member.CoffeeMaker;
import structure.facade.smart_home.member.Lights;
import structure.facade.smart_home.member.Thermostat;

public class Main {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat();
        Lights lights = new Lights();
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        SmartHomeFacade smartHome = new SmartHomeFacade(thermostat, lights, coffeeMaker);

        smartHome.wakeUp();
        smartHome.leaveHome();
    }
}