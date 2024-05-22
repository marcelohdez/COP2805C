package edu.mdc.cop2805c.assignment1;

import edu.mdc.cop2805c.assignment1.base.FuelType;
import edu.mdc.cop2805c.assignment1.base.TransmissionType;
import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.vehicles.ElectricCar;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelCar;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelMotorcycle;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelTruck;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new FossilFuelCar("234SHDSF", "Toyota", "Corolla", 2021, 1360, 2, TransmissionType.AUTOMATIC,
                        FuelType.GASOLINE),
                new FossilFuelTruck("POOKIE42", "Ford", "F150", 2023, 2260, 3.5, FuelType.GASOLINE),
                new FossilFuelMotorcycle("19BEAR99", "Something", "Else", 2024, 270, 400, 12),
                new ElectricCar("FR33P4L", "Lucid", "Air", 2024, 12)
        };

        for (Vehicle v : vehicles) {
            System.out.println(v.getDescription());
            System.out.println();
        }
    }
}
