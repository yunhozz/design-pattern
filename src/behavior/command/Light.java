package behavior.command;

// Command Interface
interface Executor {
    void execute();
}

// Receiver Class
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// Concrete Command Classes
class LightOnExecutor implements Executor {
    private final Light light;

    public LightOnExecutor(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Command
class LightOffExecutor implements Executor {
    private final Light light;

    public LightOffExecutor(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Invoker Class
class LightRemoteControl {
    private Executor executor;

    public void setCommand(Executor executor) {
        this.executor = executor;
    }

    public void pressButton() {
        executor.execute();
    }
}

class LightDemo {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Executor lightOn = new LightOnExecutor(livingRoomLight);
        Executor lightOff = new LightOffExecutor(livingRoomLight);

        LightRemoteControl remote = new LightRemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton(); // "Light is ON"

        remote.setCommand(lightOff);
        remote.pressButton(); // "Light is OFF"
    }
}