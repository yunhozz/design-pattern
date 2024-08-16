package creation.builder;

// Product class
class Computer {
    // required parameters
    private final String HDD;
    private final String RAM;

    // optional parameters
    private final boolean isGraphicsCardEnabled;
    private final boolean isBluetoothEnabled;

    // Private constructor to prevent direct instantiation
    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    // Getters
    public String getHDD() {
        return HDD;
    }

    public String getRAM() {
        return RAM;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isBluetoothEnabled() {
        return isBluetoothEnabled;
    }

    // Static nested Builder class
    public static class ComputerBuilder {
        // required parameters
        private final String HDD;
        private final String RAM;

        // optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        // Constructor with required parameters
        public ComputerBuilder(String hdd, String ram) {
            this.HDD = hdd;
            this.RAM = ram;
        }

        // Setter method for optional parameter isGraphicsCardEnabled
        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this; // returning the builder object
        }

        // Setter method for optional parameter isBluetoothEnabled
        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this; // returning the builder object
        }

        // Build method to create the Computer object
        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [HDD=" + HDD + ", RAM=" + RAM
                + ", GraphicsCardEnabled=" + isGraphicsCardEnabled
                + ", BluetoothEnabled=" + isBluetoothEnabled + "]";
    }
}

class Client {
    public static void main(String[] args) {
        // Creating a Computer object using the Builder pattern
        Computer computer = new Computer.ComputerBuilder("500 GB", "8 GB")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        // Printing the computer details
        System.out.println(computer);
    }
}