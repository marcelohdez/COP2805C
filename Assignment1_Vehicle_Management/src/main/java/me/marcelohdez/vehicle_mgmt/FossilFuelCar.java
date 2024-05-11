package me.marcelohdez.vehicle_mgmt;

import me.marcelohdez.vehicle_mgmt.base.FossilFuelVehicle;
import me.marcelohdez.vehicle_mgmt.base.Vehicle;
import me.marcelohdez.vehicle_mgmt.base.VehicleSubType;
import me.marcelohdez.vehicle_mgmt.base.VehicleType;

public class FossilFuelCar extends Vehicle implements FossilFuelVehicle  {
    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }

    public VehicleSubType getVehicleSubType() {
        return VehicleSubType.FOSSIL_FUEL;
    }

    public String getDescription() {
        return "TODO";
    }

    @Override
    public double estimateFuelEfficiency() {
        return 0;
    }

    @Override
    public double estimateCO2Emissions() {
        return 0;
    }

    @Override
    public double estimateNOxEmissions() {
        return 0;
    }
}
