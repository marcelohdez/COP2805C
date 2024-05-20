package edu.mdc.cop2805c.assignment1;

import edu.mdc.cop2805c.assignment1.base.*;

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
            FuelType fuelType
    ) {
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
        return VehicleType.CAR.toString();
    }

    @Override
    public String getVehicleSubType() {
        return VehicleSubType.FOSSIL_FUEL.toString();
    }

    @Override
    public String getDescription() {
        return String.format(
                "TRUCK %s %s %d\nVIN: %s\nWeight Rating (ton): %d\nEngine Displacement: %f\nFuel Type: %s",
                make, model, year,
                vin,
                grossVehicleWeightRatingTon,
                engineDisplacementL,
                fuelType
        );
    }

    /// Estimate fuel efficiency in MPG
    @Override
    public double estimateFuelEfficiency() {
        return 1000 * (engineDisplacementL * fuelType.getEfficiencyConstant()) / grossVehicleWeightRatingTon;
    }

    /// Estimate CO2 emissions in grams/mile
    @Override
    public double estimateCO2Emissions() {
        return estimateFuelEfficiency() * fuelType.getCO2EmissionFactor();
    }

    @Override
    public double estimateNOxEmissions() {
        return estimateFuelEfficiency() * fuelType.getNOxEmissionFactor();
    }
}
