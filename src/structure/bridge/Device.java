package structure.bridge;

// Implementor
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int volume);
    boolean isEnabled();
}

// Concrete Implementors
class TV implements Device {
    private boolean on = false;

    @Override
    public void turnOn() {
        on = true;
        System.out.println("TV is now ON.");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("TV is now OFF.");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("TV volume set to " + volume);
    }

    @Override
    public boolean isEnabled() {
        return on;
    }
}

class Radio implements Device {
    private boolean on = false;

    @Override
    public void turnOn() {
        on = true;
        System.out.println("Radio is now ON.");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("Radio is now OFF.");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("Radio volume set to " + volume);
    }

    @Override
    public boolean isEnabled() {
        return on;
    }
}

// Abstraction
abstract class Remote {
    protected Device device;

    protected Remote(Device device) {
        this.device = device;
    }

    public void volumeUp() {
        device.setVolume(device.isEnabled() ? 1 : 0);
    }

    public void volumeDown() {
        device.setVolume(device.isEnabled() ? -1 : 0);
    }

    public abstract void power();
}

// Refined Abstractions
class BasicRemote extends Remote {

    public BasicRemote(Device device) {
        super(device);
    }

    @Override
    public void power() {
        if (device.isEnabled()) {
            device.turnOff();
        } else {
            device.turnOn();
        }
    }
}

class AdvancedRemote extends Remote {

    public AdvancedRemote(Device device) {
        super(device);
    }

    @Override
    public void power() {
        if (device.isEnabled()) {
            device.turnOff();
        } else {
            device.turnOn();
        }
    }

    public void mute() {
        device.setVolume(0);
        System.out.println("Device is muted.");
    }
}

// Client
class DeviceDemo {
    public static void main(String[] args) {
        Device tv = new TV();
        Remote basicRemote = new BasicRemote(tv);
        basicRemote.power();
        basicRemote.volumeUp();

        System.out.println();

        Device radio = new Radio();
        AdvancedRemote advancedRemote = new AdvancedRemote(radio);
        advancedRemote.power();
        advancedRemote.mute();
    }
}