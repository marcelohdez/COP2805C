package edu.mdc.cop2805c.assignment1;

import edu.mdc.cop2805c.assignment1.base.FuelType;
import edu.mdc.cop2805c.assignment1.base.TransmissionType;
import edu.mdc.cop2805c.assignment1.base.Vehicle;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new FossilFuelCar("234SHDSF", "Toyota", "Corolla", 2021, 1360, 2, TransmissionType.AUTOMATIC, FuelType.GASOLINE);
        Vehicle truck = new FossilFuelTruck("POOKIE42", "Ford", "F150", 2023, 2260, 3.5, FuelType.GASOLINE);

        System.out.println(car.getDescription() + "\n");
        System.out.println(truck.getDescription());
    }
}