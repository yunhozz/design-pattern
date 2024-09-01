package behavior.command;

import java.util.Stack;

// Command Interface
interface Command {
    void execute();
    void undo();
}

// Receiver Class
class TV {
    private int volume = 10;
    private int channel = 1;

    public void volumeUp() {
        volume++;
        System.out.println("TV volume is increased to " + volume);
    }

    public void volumeDown() {
        volume--;
        System.out.println("TV volume is decreased to " + volume);
    }

    public void channelUp() {
        channel++;
        System.out.println("TV channel is increased to " + channel);
    }

    public void channelDown() {
        channel--;
        System.out.println("TV channel is decreased to " + channel);
    }

    public int getVolume() {
        return volume;
    }

    public int getChannel() {
        return channel;
    }
}

// ConcreteCommand Classes
class VolumeUpCommand implements Command {
    private final TV tv;

    public VolumeUpCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.volumeUp();
    }

    @Override
    public void undo() {
        tv.volumeDown();
    }
}

class VolumeDownCommand implements Command {
    private final TV tv;

    public VolumeDownCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.volumeDown();
    }

    @Override
    public void undo() {
        tv.volumeUp();
    }
}

class ChannelUpCommand implements Command {
    private final TV tv;

    public ChannelUpCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.channelUp();
    }

    @Override
    public void undo() {
        tv.channelDown();
    }
}

class ChannelDownCommand implements Command {
    private final TV tv;

    public ChannelDownCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.channelDown();
    }

    @Override
    public void undo() {
        tv.channelUp();
    }
}

// Invoker Class
class TVRemoteControl {
    private Command command;
    private final Stack<Command> commandHistory = new Stack<>();

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        commandHistory.push(command);
    }

    public void pressUndo() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        }
    }

    public void showHistory() {
        System.out.println("Command History:");
        for (Command cmd : commandHistory) {
            System.out.println(cmd.getClass().getSimpleName());
        }
    }
}

class TVDemo {
    public static void main(String[] args) {
        TV tv = new TV();

        Command volumeUp = new VolumeUpCommand(tv);
        Command volumeDown = new VolumeDownCommand(tv);
        Command channelUp = new ChannelUpCommand(tv);
        Command channelDown = new ChannelDownCommand(tv);

        TVRemoteControl remote = new TVRemoteControl();

        remote.setCommand(volumeUp);
        remote.pressButton();
        // Output: TV volume is increased to 11

        remote.setCommand(channelUp);
        remote.pressButton();
        // Output: TV channel is increased to 2

        remote.setCommand(volumeDown);
        remote.pressButton();
        // Output: TV volume is decreased to 10

        remote.setCommand(channelDown);
        remote.pressButton();
        // Output: TV channel is decreased to 1

        remote.showHistory();
        // Output:
        // Command History:
        // VolumeUpCommand
        // ChannelUpCommand
        // VolumeDownCommand
        // ChannelDownCommand

        remote.pressUndo();
        // Output: TV channel is increased to 2

        remote.pressUndo();
        // Output: TV volume is increased to 11
    }
}