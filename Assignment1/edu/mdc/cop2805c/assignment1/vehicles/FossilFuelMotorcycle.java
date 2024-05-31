package edu.mdc.cop2805c.assignment1.vehicles;

import edu.mdc.cop2805c.assignment1.base.*;
import edu.mdc.cop2805c.assignment1.interfaces.FossilFuelVehicle;

public class FossilFuelMotorcycle extends Vehicle implements FossilFuelVehicle {
    // No Diesel Motorcycles...
    final FossilFuelType FOSSIL_FUEL_TYPE = FossilFuelType.GASOLINE;

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
            double frontalAreaSqM) {
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
        return TYPE_MOTORCYCLE;
    }

    @Override
    public String getVehicleSubType() {
        return SUBTYPE_FOSSIL_FUEL;
    }

    @Override
    public String getDescription() {
        return String.format(
                "%s,%s,%s,%s,%s,%d,%d,%f,%f",
                getVehicleType(),
                getVehicleSubType(),
                vin, make, model, year, weightKg, engineDisplacementCC, frontalAreaSqM);
    }

    /// Estimate fuel efficiency in MPG
    @Override
    public double estimateFuelEfficiency() {
        return (46.64 - (0.0049 * weightKg) - (0.008 * engineDisplacementCC)) / (3.5 * frontalAreaSqM);
    }

    /// Estimate CO2 emissions in grams/mile
    @Override
    public double estimateCO2Emissions() {
        return estimateFuelEfficiency() * FOSSIL_FUEL_TYPE.getCO2EmissionFactor(getVehicleType());
    }

    @Override
    public double estimateNOxEmissions() {
        return estimateFuelEfficiency() * FOSSIL_FUEL_TYPE.getNOxEmissionFactor(getVehicleType());
    }
}
