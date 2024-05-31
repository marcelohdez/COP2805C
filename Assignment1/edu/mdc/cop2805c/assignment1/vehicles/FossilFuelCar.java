package edu.mdc.cop2805c.assignment1.vehicles;

import edu.mdc.cop2805c.assignment1.base.*;
import edu.mdc.cop2805c.assignment1.interfaces.FossilFuelVehicle;

public class FossilFuelCar extends Vehicle implements FossilFuelVehicle {
    int weightKg;
    double engineDisplacementL;
    TransmissionType transmissionType;
    FossilFuelType fossilFuelType;

    public FossilFuelCar(
            String VIN,
            String make,
            String model,
            int year,
            int weightKg,
            double engineDisplacementL,
            TransmissionType transmissionType,
            FossilFuelType fossilFuelType) {
        this.vin = VIN;
        this.make = make;
        this.model = model;
        this.year = year;

        this.weightKg = weightKg;
        this.engineDisplacementL = engineDisplacementL;
        this.transmissionType = transmissionType;
        this.fossilFuelType = fossilFuelType;
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }

    @Override
    public String getVehicleSubType() {
        return "Fossil Fuel";
    }

    @Override
    public String getDescription() {
        return String.format(
                "%s,%s,%s,%s,%s,%d,%d,%f,%s,%s",
                getVehicleType(),
                getVehicleSubType(),
                vin, make, model, year, weightKg, engineDisplacementL,
                fossilFuelType.getOrdinal(),
                transmissionType.getOrdinal());
    }

    /** Estimate fuel efficiency in MPG */
    @Override
    public double estimateFuelEfficiency() {
        return (0.5 * Math.pow(engineDisplacementL, 2.5)) /
                (Math.pow(weightKg, 0.6) * transmissionType.getMultiplier())
                * 1000;
    }

    /** Estimate CO2 emissions in grams/mile */
    @Override
    public double estimateCO2Emissions() {
        return estimateFuelEfficiency() * fossilFuelType.getCO2EmissionFactor(Vehicle.TYPE_CAR);
    }

    @Override
    public double estimateNOxEmissions() {
        return estimateFuelEfficiency() * fossilFuelType.getNOxEmissionFactor(Vehicle.TYPE_CAR);
    }
}
