package creation.factory_method.vehicle_factory.factory;

import creation.factory_method.vehicle_factory.vehicle.Motorcycle;
import creation.factory_method.vehicle_factory.vehicle.Vehicle;

public class MotorcycleFactory extends VehicleFactory {

    @Override
    protected Vehicle createVehicle() {
        System.out.println("Create motorcycle");
        return new Motorcycle();
    }
}
