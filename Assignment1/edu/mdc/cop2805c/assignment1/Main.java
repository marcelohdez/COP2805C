package edu.mdc.cop2805c.assignment1;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.mdc.cop2805c.assignment1.base.FuelType;
import edu.mdc.cop2805c.assignment1.base.TransmissionType;
import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.inventory.VehicleFileManager;
import edu.mdc.cop2805c.assignment1.vehicles.ElectricCar;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelCar;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelMotorcycle;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelTruck;

public class Main {
    private static final String FILE_NAME = "out/vehicles.txt";

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<Vehicle>(Arrays.asList(new Vehicle[] {
                new ElectricCar("D1WFPVCXA4EKQSZ1", "Tesla", "Model S", 2023, 0.4),
                new FossilFuelCar("K1MT9ZBH5L39XE7T", "Toyota", "Corolla LE", 2023, 1288, 1.8,
                        TransmissionType.Automatic,
                        FuelType.Gasoline),
                new FossilFuelTruck("F1IV42N2L6GT8SIP", "Volvo", "VNL", 2020, 33000, 10.8, FuelType.Gasoline),
                new FossilFuelMotorcycle("V1GT6OSK64BVUDIS", "Honda", "CBR500R", 2022, 191, 471, 0.96),
        }));

        VehicleFileManager.saveVehiclesToFile(vehicles, FILE_NAME);

        try (FileReader fr = new FileReader(FILE_NAME)) {
            while (fr.ready()) {
                // sb.append((char) fr.read());
                System.out.print((char) fr.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
