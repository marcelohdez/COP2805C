package edu.mdc.cop2805c.assignment1;

import edu.mdc.cop2805c.assignment1.base.*;

public class FossilFuelMotorcycle extends Vehicle implements FossilFuelVehicle {
    // No Diesel Motorcycles...
    final FuelType FUEL_TYPE = FuelType.GASOLINE;

    int weightKg;
    double engineDisplacementCC;
    double frontalAreaSqM;

    public FossilFuelMotorcycle(
            String VIN,
            String make,
            String model,
            int year,
            int weightKg,
            double engineDisplacementCC,
            double frontalAreaSqM
    ) {
        this.vin = VIN;
        this.make = make;
        this.model = model;
        this.year = year;

        this.weightKg = weightKg;
        this.engineDisplacementCC = engineDisplacementCC;
        this.frontalAreaSqM = frontalAreaSqM;
    }

    @Override
    public String getVehicleType() {
        return VehicleType.MOTORCYCLE.toString();
    }

    @Override
    public String getVehicleSubType() {
        return VehicleSubType.FOSSIL_FUEL.toString();
    }

    @Override
    public String getDescription() {
        return String.format(
                "%s %s\n%s %s %d\nVIN: %s\nWeight (kg): %d\nEngine Displacement: %f CC\nFrontal Area: %f M²",
                getVehicleSubType(), getVehicleType(),
                make, model, year,
                vin,
                weightKg,
                engineDisplacementCC,
                frontalAreaSqM
        );
    }

    /// Estimate fuel efficiency in MPG
    @Override
    public double estimateFuelEfficiency() {
        return (46.64 - (0.0049 * weightKg) - (0.008 * engineDisplacementCC)) / (3.5 * frontalAreaSqM);
    }

    /// Estimate CO2 emissions in grams/mile
    @Override
    public double estimateCO2Emissions() {
        return estimateFuelEfficiency() * FUEL_TYPE.getCO2EmissionFactor(VehicleType.MOTORCYCLE);
    }

    @Override
    public double estimateNOxEmissions() {
        return estimateFuelEfficiency() * FUEL_TYPE.getNOxEmissionFactor(VehicleType.MOTORCYCLE);
    }
}
