package creation.factory_method.vehicle_factory.factory;

import creation.factory_method.vehicle_factory.vehicle.Vehicle;

public abstract class VehicleFactory {

    protected abstract Vehicle createVehicle();

    public void deliverVehicle() {
        Vehicle vehicle = createVehicle();
        System.out.println("Vehicle to be delivered");
        vehicle.drive();
    }
}
