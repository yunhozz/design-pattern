package behavior.state;

interface DoorState {
    void open(Door door);
    void close(Door door);
}

class OpenState implements DoorState {
    @Override
    public void open(Door door) {
        System.out.println("Door is already Open.");
    }

    @Override
    public void close(Door door) {
        System.out.println("Door is now Closed.");
        door.setState(new ClosedState());
    }
}

class ClosedState implements DoorState {
    @Override
    public void open(Door door) {
        System.out.println("Door is now Open.");
        door.setState(new OpenState());
    }

    @Override
    public void close(Door door) {
        System.out.println("Door is already Closed.");
    }
}

class Door {
    private DoorState state;

    // Set initial state Closed
    public Door() {
        this.state = new ClosedState();
    }

    public void setState(DoorState state) {
        this.state = state;
    }

    public void open() {
        state.open(this);
    }

    public void close() {
        state.close(this);
    }
}

class DoorDemo {
    public static void main(String[] args) {
        Door door = new Door();
        door.open();  // Door is now Open.
        door.open();  // Door is already Open.
        door.close(); // Door is now Closed.
        door.close(); // Door is already Closed.
    }
}