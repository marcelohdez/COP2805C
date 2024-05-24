package edu.mdc.cop2805c.assignment1.inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import edu.mdc.cop2805c.assignment1.base.FuelType;
import edu.mdc.cop2805c.assignment1.base.TransmissionType;
import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.base.VehicleSubType;
import edu.mdc.cop2805c.assignment1.base.VehicleType;
import edu.mdc.cop2805c.assignment1.vehicles.ElectricCar;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelCar;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelMotorcycle;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelTruck;

public class VehicleFileManager {
    public static void saveVehiclesToFile(List<Vehicle> Vehicles, String filename) {
        try (FileWriter fw = new FileWriter(filename)) {
            for (Vehicle v : Vehicles) {
                fw.write(v.getDescription() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Could not save vehicles to file!");
            e.printStackTrace();
        }
    }

    public static List<Vehicle> loadVehiclesFromFile(String filename) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        try (Scanner scn = new Scanner(new File(filename))) {
            while (scn.hasNextLine()) {
                String[] values = scn.nextLine().split(",");

                VehicleType vtype = VehicleType.valueOf(values[0]);
                VehicleSubType vstype = VehicleSubType.smartValueOf(values[1]);
                String vin = values[2];
                String make = values[3];
                String model = values[4];
                int year = Integer.valueOf(values[5]);

                Optional<Vehicle> v = Optional.ofNullable(null);
                switch (vtype) {
                    case Car:
                        switch (vstype) {
                            case Electric:
                                v = Optional.of(new ElectricCar(vin, make, model, year, Double.valueOf(values[6])));
                                break;

                            case Fossil_Fuel:
                                v = Optional.of(new FossilFuelCar(vin, make, model, year, Integer.valueOf(values[6]),
                                        Double.valueOf(values[7]), TransmissionType.valueOf(Integer.valueOf(values[8])),
                                        FuelType.valueOf(Integer.valueOf(values[9]))));
                                break;

                        }
                        break;

                    case Truck:
                        if (vstype != VehicleSubType.Fossil_Fuel)
                            break;
                        v = Optional.of(new FossilFuelTruck(vin, make, model, year, Integer.valueOf(values[6]),
                                Double.valueOf(values[7]), FuelType.valueOf(Integer.valueOf(values[8]))));
                        break;

                    case Motorcycle:
                        if (vstype != VehicleSubType.Fossil_Fuel)
                            break;
                        v = Optional.of(new FossilFuelMotorcycle(vin, make, model, year, Integer.valueOf(values[6]),
                                Double.valueOf(values[7]), Double.valueOf(values[8])));
                        break;
                }

                if (v.isPresent()) {
                    vehicles.add(v.get());
                } else {
                    throw new InvalidPropertiesFormatException("Unknown vehicle makeup: " + Arrays.toString(values));
                }
            }
        } catch (FileNotFoundException | InvalidPropertiesFormatException e) {
            e.printStackTrace();
        }

        return vehicles;
    }
}
