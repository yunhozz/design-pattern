package structure.facade;

class Thermostat {
    public void setTemperature(int temperature) {
        System.out.println("Setting thermostat to " + temperature + " degrees.");
    }
}

class Lights {
    public void on() {
        System.out.println("Lights are on.");
    }

    public void off() {
        System.out.println("Lights are off.");
    }
}

class CoffeeMaker {
    public void brewCoffee() {
        System.out.println("Brewing coffee.");
    }
}

class SmartHomeFacade {
    private final Thermostat thermostat;
    private final Lights lights;
    private final CoffeeMaker coffeeMaker;

    public SmartHomeFacade(Thermostat thermostat, Lights lights, CoffeeMaker coffeeMaker) {
        this.thermostat = thermostat;
        this.lights = lights;
        this.coffeeMaker = coffeeMaker;
    }

    public void wakeUp() {
        System.out.println("Waking up...");
        thermostat.setTemperature(22);
        lights.on();
        coffeeMaker.brewCoffee();
    }

    public void leaveHome() {
        System.out.println("Leaving home...");
        thermostat.setTemperature(18);
        lights.off();
    }
}

class SmartHomeDemo {
    public static void main(String[] args) {
        Thermostat thermostat = new Thermostat();
        Lights lights = new Lights();
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        SmartHomeFacade smartHome = new SmartHomeFacade(thermostat, lights, coffeeMaker);

        smartHome.wakeUp();
        smartHome.leaveHome();
    }
}