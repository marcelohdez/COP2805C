package edu.mdc.cop2805c.assignment1.vehicles;

import edu.mdc.cop2805c.assignment1.base.*;
import edu.mdc.cop2805c.assignment1.interfaces.FossilFuelVehicle;

public class FossilFuelTruck extends Vehicle implements FossilFuelVehicle {
    int grossVehicleWeightRatingTon;
    double engineDisplacementL;
    FossilFuelType fossilFuelType;

    public FossilFuelTruck(
            String VIN,
            String make,
            String model,
            int year,
            int weightRatingTon,
            double engineDisplacementL,
            FossilFuelType fossilFuelType) {
        this.vin = VIN;
        this.make = make;
        this.model = model;
        this.year = year;

        this.grossVehicleWeightRatingTon = weightRatingTon;
        this.engineDisplacementL = engineDisplacementL;
        this.fossilFuelType = fossilFuelType;
    }

    @Override
    public String getVehicleType() {
        return TYPE_TRUCK;
    }

    @Override
    public String getVehicleSubType() {
        return SUBTYPE_FOSSIL_FUEL;
    }

    @Override
    public String getDescription() {
        return String.format(
                "%s,%s,%s,%s,%s,%d,%d,%f,%s",
                getVehicleType(),
                getVehicleSubType(),
                vin, make, model, year, grossVehicleWeightRatingTon, engineDisplacementL,
                fossilFuelType.getOrdinal());
    }

    /// Estimate fuel efficiency in MPG
    @Override
    public double estimateFuelEfficiency() {
        return 1000 * (engineDisplacementL * fossilFuelType.getTruckEfficiencyConstant()) / grossVehicleWeightRatingTon;
    }

    /// Estimate CO2 emissions in grams/mile
    @Override
    public double estimateCO2Emissions() {
        return estimateFuelEfficiency() * fossilFuelType.getCO2EmissionFactor(getVehicleType());
    }

    @Override
    public double estimateNOxEmissions() {
        return estimateFuelEfficiency() * fossilFuelType.getNOxEmissionFactor(getVehicleType());
    }
}
