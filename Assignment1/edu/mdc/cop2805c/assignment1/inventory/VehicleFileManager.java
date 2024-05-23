package edu.mdc.cop2805c.assignment1.inventory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import edu.mdc.cop2805c.assignment1.base.Vehicle;

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
        return null;
    }
}
