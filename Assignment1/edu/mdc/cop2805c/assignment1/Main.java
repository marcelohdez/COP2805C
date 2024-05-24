package edu.mdc.cop2805c.assignment1;

import java.util.List;

import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.inventory.VehicleFileManager;

public class Main {
    private static final String OUT_NAME = "out/vehicles.txt";
    private static final String IN_NAME = "test/vehicles.txt";

    public static void main(String[] args) {
        List<Vehicle> list = VehicleFileManager.loadVehiclesFromFile(IN_NAME);
        VehicleFileManager.saveVehiclesToFile(list, OUT_NAME);
    }
}
