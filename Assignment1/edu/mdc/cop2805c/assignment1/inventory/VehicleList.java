package edu.mdc.cop2805c.assignment1.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.mdc.cop2805c.assignment1.base.Vehicle;

/**
 * Wrapper around an ArrayList<Vehicle> with filtering and write-to-file
 * methods
 */
public class VehicleList {
    private List<Vehicle> list;

    public VehicleList() {
        list = new ArrayList<Vehicle>();
    }

    public VehicleList(String filename) {
        list = VehicleFileManager.loadVehiclesFromFile(filename);
    }

    public void addVehicle(Vehicle vehicle) {
        list.add(vehicle);
    }

    public void removeVehicle(int index) {
        list.remove(index);
    }

    public void removeVehicle(Vehicle vehicle) {
        list.remove(vehicle);
    }

    public Vehicle get(int index) {
        return list.get(index);
    }

    /** Returns the size of this instance's internal list */
    public int size() {
        return list.size();
    }

    /**
     * Returns a *new* ArrayList<Vehicle> which is a copy of this object's
     * internal list
     */
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(list);
    }

    /**
     * Returns a new list containing the filtered items where
     * v.getVehicleType().equals(type)
     */
    public List<Vehicle> getAllVehiclesByType(String type) {
        return list.stream()
                .filter((vehicle) -> vehicle.getVehicleType().equals(type))
                .collect(Collectors.toList());
    }

    public void saveToFile(String filename) {
        VehicleFileManager.saveVehiclesToFile(list, filename);
    }
}
