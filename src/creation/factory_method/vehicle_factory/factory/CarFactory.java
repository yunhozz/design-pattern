package creation.factory_method.vehicle_factory.factory;

import creation.factory_method.vehicle_factory.vehicle.Car;
import creation.factory_method.vehicle_factory.vehicle.Vehicle;

public class CarFactory extends VehicleFactory {

    @Override
    protected Vehicle createVehicle() {
        System.out.println("Create car");
        return new Car();
    }
}
