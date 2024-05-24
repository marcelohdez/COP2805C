package edu.mdc.cop2805c.assignment1.vehicles;

import edu.mdc.cop2805c.assignment1.base.*;
import edu.mdc.cop2805c.assignment1.interfaces.FossilFuelVehicle;

public class FossilFuelTruck extends Vehicle implements FossilFuelVehicle {
    int grossVehicleWeightRatingTon;
    double engineDisplacementL;
    FuelType fuelType;

    public FossilFuelTruck(
            String VIN,
            String make,
            String model,
            int year,
            int weightRatingTon,
            double engineDisplacementL,
            FuelType fuelType) {
        this.vin = VIN;
        this.make = make;
        this.model = model;
        this.year = year;

        this.grossVehicleWeightRatingTon = weightRatingTon;
        this.engineDisplacementL = engineDisplacementL;
        this.fuelType = fuelType;
    }

    @Override
    public String getVehicleType() {
        return VehicleType.Truck.toString();
    }

    @Override
    public String getVehicleSubType() {
        return VehicleSubType.Fossil_Fuel.toString();
    }

    @Override
    public String getDescription() {
        return String.format(
                "%s,%s,%s,%s,%s,%d,%d,%f,%s",
                getVehicleType(),
                getVehicleSubType(),
                vin, make, model, year, grossVehicleWeightRatingTon, engineDisplacementL,
                fuelType.getOrdinal());
    }

    /// Estimate fuel efficiency in MPG
    @Override
    public double estimateFuelEfficiency() {
        return 1000 * (engineDisplacementL * fuelType.getTruckEfficiencyConstant()) / grossVehicleWeightRatingTon;
    }

    /// Estimate CO2 emissions in grams/mile
    @Override
    public double estimateCO2Emissions() {
        return estimateFuelEfficiency() * fuelType.getCO2EmissionFactor(VehicleType.Truck);
    }

    @Override
    public double estimateNOxEmissions() {
        return estimateFuelEfficiency() * fuelType.getNOxEmissionFactor(VehicleType.Truck);
    }
}
