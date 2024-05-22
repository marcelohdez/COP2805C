package edu.mdc.cop2805c.assignment1.vehicles;

import edu.mdc.cop2805c.assignment1.interfaces.ElectricVehicle;
import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.base.VehicleSubType;
import edu.mdc.cop2805c.assignment1.base.VehicleType;

public class ElectricCar extends Vehicle implements ElectricVehicle {
    double electricityConsumedPerMilekWh;

    public ElectricCar(
            String VIN,
            String make,
            String model,
            int year,
            double electricityConsumedPerMilekWh) {
        this.vin = VIN;
        this.make = make;
        this.model = model;
        this.year = year;

        this.electricityConsumedPerMilekWh = electricityConsumedPerMilekWh;
    }

    @Override
    public double estimateFuelEfficiencyEquivalent() {
        return 33.7 / electricityConsumedPerMilekWh;
    }

    @Override
    public String getVehicleType() {
        return VehicleType.CAR.toString();
    }

    @Override
    public String getVehicleSubType() {
        return VehicleSubType.ELECTRIC.toString();
    }

    @Override
    public String getDescription() {
        return String.format(
                "%s %s\n%s %s %d\nVIN: %s\nElectricity Consumed/Mile: %f kWh",
                getVehicleSubType(), getVehicleType(),
                make, model, year,
                vin,
                electricityConsumedPerMilekWh);
    }
}