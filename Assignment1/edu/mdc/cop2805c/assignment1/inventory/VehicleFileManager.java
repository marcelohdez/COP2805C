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
import edu.mdc.cop2805c.assignment1.vehicles.ElectricCar;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelCar;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelMotorcycle;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelTruck;

public class VehicleFileManager {
    public static void saveVehiclesToFile(List<Vehicle> vehicles, String filename) {
        try (FileWriter fw = new FileWriter(filename)) {
            for (Vehicle v : vehicles) {
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
                String line = scn.nextLine();
                if (line.isEmpty())
                    break;

                String[] values = line.split(",");

                String vtype = values[0];
                String vstype = values[1];
                String vin = values[2];
                String make = values[3];
                String model = values[4];
                int year = Integer.valueOf(values[5]);

                Optional<Vehicle> v = Optional.ofNullable(null);
                switch (vtype) {
                    case Vehicle.TYPE_CAR:
                        switch (vstype) {
                            case Vehicle.SUBTYPE_ELECTRIC:
                                v = Optional.of(new ElectricCar(vin, make, model, year, Double.valueOf(values[6])));
                                break;

                            case Vehicle.SUBTYPE_FOSSIL_FUEL:
                                v = Optional.of(new FossilFuelCar(vin, make, model, year, Integer.valueOf(values[6]),
                                        Double.valueOf(values[7]), TransmissionType.valueOf(Integer.valueOf(values[8])),
                                        FuelType.valueOf(Integer.valueOf(values[9]))));
                                break;

                        }
                        break;

                    case Vehicle.TYPE_TRUCK:
                        if (!vstype.equals(Vehicle.SUBTYPE_FOSSIL_FUEL))
                            break;
                        v = Optional.of(new FossilFuelTruck(vin, make, model, year, Integer.valueOf(values[6]),
                                Double.valueOf(values[7]), FuelType.valueOf(Integer.valueOf(values[8]))));
                        break;

                    case Vehicle.TYPE_MOTORCYCLE:
                        if (!vstype.equals(Vehicle.SUBTYPE_FOSSIL_FUEL))
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
