package edu.mdc.cop2805c.assignment1.vehicles;

import edu.mdc.cop2805c.assignment1.base.*;
import edu.mdc.cop2805c.assignment1.interfaces.FossilFuelVehicle;

public class FossilFuelCar extends Vehicle implements FossilFuelVehicle {
    int weightKg;
    double engineDisplacementL;
    TransmissionType transmissionType;
    FuelType fuelType;

    public FossilFuelCar(
            String VIN,
            String make,
            String model,
            int year,
            int weightKg,
            double engineDisplacementL,
            TransmissionType transmissionType,
            FuelType fuelType) {
        this.vin = VIN;
        this.make = make;
        this.model = model;
        this.year = year;

        this.weightKg = weightKg;
        this.engineDisplacementL = engineDisplacementL;
        this.transmissionType = transmissionType;
        this.fuelType = fuelType;
    }

    @Override
    public String getVehicleType() {
        return VehicleType.Car.toString();
    }

    @Override
    public String getVehicleSubType() {
        return VehicleSubType.Fossil_Fuel.toString();
    }

    @Override
    public String getDescription() {
        // return String.format(
        // "%s,%s,%s,%s,%s,%d,%f",
        // getVehicleType(),
        // getVehicleSubType(),
        // vin, make, model, year, electricityConsumedPerMilekWh);

        return String.format(
                "%s,%s,%s,%s,%s,%d,%d,%f,%s,%s",
                getVehicleType(),
                getVehicleSubType(),
                vin, make, model, year, weightKg, engineDisplacementL, transmissionType, fuelType);
    }

    /// Estimate fuel efficiency in MPG
    @Override
    public double estimateFuelEfficiency() {
        return (0.5 * Math.pow(engineDisplacementL, 2.5)) /
                (Math.pow(weightKg, 0.6) * transmissionType.getMultiplier())
                * 1000;
    }

    /// Estimate CO2 emissions in grams/mile
    @Override
    public double estimateCO2Emissions() {
        return estimateFuelEfficiency() * fuelType.getCO2EmissionFactor(VehicleType.Car);
    }

    @Override
    public double estimateNOxEmissions() {
        return estimateFuelEfficiency() * fuelType.getNOxEmissionFactor(VehicleType.Car);
    }
}
