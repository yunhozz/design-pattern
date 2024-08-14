package creation.factory_method;

// Product interface
interface Vehicle {
    void drive();
}

// Concrete products
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car");
    }
}

class Motorcycle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a motorcycle");
    }
}

// Creator abstract class
abstract class VehicleFactory {
    // Factory method
    abstract Vehicle createVehicle();

    // Operations using the factory method
    public void deliverVehicle() {
        Vehicle vehicle = createVehicle();
        System.out.println("Delivering the vehicle:");
        vehicle.drive();
    }
}

// Concrete creators
class CarFactory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}

class MotorcycleFactory extends VehicleFactory {
    @Override
    Vehicle createVehicle() {
        return new Motorcycle();
    }
}

// Client code
class VehicleFactoryDemo {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        carFactory.deliverVehicle();

        VehicleFactory motorcycleFactory = new MotorcycleFactory();
        motorcycleFactory.deliverVehicle();
    }
}