package edu.mdc.cop2805c.assignment1.app;

import java.util.List;
import java.util.Scanner;

import edu.mdc.cop2805c.assignment1.base.FossilFuelType;
import edu.mdc.cop2805c.assignment1.base.TransmissionType;
import edu.mdc.cop2805c.assignment1.base.Vehicle;
import edu.mdc.cop2805c.assignment1.interfaces.ElectricVehicle;
import edu.mdc.cop2805c.assignment1.interfaces.FossilFuelVehicle;
import edu.mdc.cop2805c.assignment1.inventory.VehicleFileManager;
import edu.mdc.cop2805c.assignment1.inventory.VehicleList;
import edu.mdc.cop2805c.assignment1.vehicles.ElectricCar;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelCar;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelMotorcycle;
import edu.mdc.cop2805c.assignment1.vehicles.FossilFuelTruck;

public class VehicleManager {
    private static final String FILE_NAME = "vehicles.txt";
    private static VehicleList vehicles = new VehicleList(FILE_NAME);

    public static void main(String[] args) {
        try (Scanner scn = new Scanner(System.in)) {
            String choice = "";

            do {
                if (!choice.isEmpty())
                    takeAction(choice, scn);

                printDivisor("=");
                printMenu();
                choice = scn.nextLine().trim().toLowerCase();
                printDivisor("-");
            } while (!choice.equals("q"));
        }

        VehicleFileManager.saveVehiclesToFile(vehicles.getAllVehicles(), FILE_NAME);
    }

    private static void printDivisor(String replace) {
        System.out.println("\n==================================".replaceAll("=", replace));
    }

    private static void printMenu() {
        System.out.println("1) View all vehicles in the system");
        System.out.println("2) View vehicles by type");
        System.out.println("3) Add a new vehicle");
        System.out.println("4) Remove an existing vehicle");
        System.out.println("5) Display fuel efficiency and/or emissions for a vehicle");
        System.out.println("6) Display fuel efficiency and/or emissions for a vehicle type");
        System.out.println("7) Display fuel efficiency and/or emissions for all vehicles");
        System.out.println("q) Exit");
    }

    /**
     * Do the given action for *choice* and if needed, use *scn* to take new input
     */
    private static void takeAction(String choice, Scanner scn) {
        int index = -1; // avoid creating twice

        switch (choice) {
            case "1":
                for (int i = 0; i < vehicles.size(); i++)
                    System.out.println(vehicles.get(i).getDescription());

                break;
            case "2":
                System.out.println("What type? (Car, Truck, Motorcycle)");
                for (Vehicle v : vehicles.getAllVehiclesByType(scn.nextLine()))
                    System.out.println(v.getDescription());

                break;
            case "3":
                vehicles.addVehicle(createVehicle(scn));
                break;
            case "4":
                index = userChooseIndex(vehicles.getAllVehicles(), scn);
                if (index < 0)
                    return;

                vehicles.removeVehicle(index);
                break;
            case "5":
                index = userChooseIndex(vehicles.getAllVehicles(), scn);
                if (index < 0)
                    return;

                printEfficiencyEmissionsOf(vehicles.get(index));
                break;
            case "6":
                System.out.println("What type? (Car, Truck, Motorcycle)");
                List<Vehicle> list = vehicles.getAllVehiclesByType(scn.nextLine());
                index = userChooseIndex(list, scn);
                if (index < 0)
                    return;

                printEfficiencyEmissionsOf(list.get(index));
                break;
            case "7":
                for (int i = 0; i < vehicles.size(); i++) {
                    System.out.print(vehicles.get(i).getDescription() + ":\n");
                    printEfficiencyEmissionsOf(vehicles.get(i));
                    System.out.println();
                }
        }
    }

    /**
     * Will loop until user chooses an index from the list, returns -1 if list is
     * empty.
     */
    private static int userChooseIndex(List<Vehicle> vehicles, Scanner scn) {
        if (vehicles.size() == 0) {
            System.out.println("There are no vehicles in the list!");
            return -1;
        }

        int index = 0;
        while (true) {
            for (int i = 0; i < vehicles.size(); i++)
                System.out.println((i + 1) + ") " + vehicles.get(i).getDescription());

            System.out.println("Which index would you like to remove?");
            index = Integer.parseInt(scn.nextLine()) - 1;
            if (index < 0 || index >= vehicles.size()) {
                System.out.println("Index out of range! Try again.");
                continue;
            }

            break;
        }
        return index;
    }

    private static void printEfficiencyEmissionsOf(Vehicle v) {
        if (v instanceof ElectricVehicle) {
            ElectricVehicle ev = (ElectricVehicle) v;

            System.out.println("\tFuel Efficiency Equivalent: " + ev.estimateFuelEfficiencyEquivalent());
        } else if (v instanceof FossilFuelVehicle) {
            FossilFuelVehicle ffv = (FossilFuelVehicle) v;

            System.out.println(
                    String.format("\tFuel Efficiency (MPG): %f\n\tCO2 Emissions (g/mile): %f\n\tNOx Emissions: %f",
                            ffv.estimateFuelEfficiency(),
                            ffv.estimateCO2Emissions(),
                            ffv.estimateNOxEmissions()));
        }
    }

    /** Will build a vehicle from newline-separated input */
    private static Vehicle createVehicle(Scanner scn) {
        System.out.println("What type? (Car, Truck, Motorcycle)");
        String vtype = scn.nextLine();

        System.out.println("What subtype? (Electric, Fossil Fuel)");
        String vstype = scn.nextLine();

        System.out.println("Vin?");
        String vin = scn.nextLine();

        System.out.println("Make?");
        String make = scn.nextLine();

        System.out.println("Model?");
        String model = scn.nextLine();

        System.out.println("Year?");
        int year = Integer.parseInt(scn.nextLine());

        switch (vtype) {
            case Vehicle.TYPE_CAR:
                switch (vstype) {
                    case Vehicle.SUBTYPE_ELECTRIC:
                        System.out.println("kWh used per mile?");
                        return new ElectricCar(vin, make, model, year, Double.parseDouble(scn.nextLine()));

                    case Vehicle.SUBTYPE_FOSSIL_FUEL:
                        System.out.println("Weight (in Kg)");
                        int weightKg = Integer.parseInt(scn.nextLine());

                        System.out.println("Engine Displacement in Liters?");
                        double ed = Double.parseDouble(scn.nextLine());

                        System.out.println("Transmission Type? (Automatic, Manual)");
                        TransmissionType tt = TransmissionType.valueOf(scn.nextLine());

                        System.out.println("Fuel Type? (Gasoline, Diesel)");
                        FossilFuelType ft = FossilFuelType.valueOf(scn.nextLine());

                        return new FossilFuelCar(vin, make, model, year, weightKg, ed, tt, ft);
                }
                break;

            case Vehicle.TYPE_TRUCK:
                if (vstype.equals(Vehicle.SUBTYPE_FOSSIL_FUEL)) {
                    System.out.println("Weight Rating (in Tons)");
                    int rating = Integer.parseInt(scn.nextLine());

                    System.out.println("Engine Displacement in Liters?");
                    double ed = Double.parseDouble(scn.nextLine());

                    System.out.println("Fuel Type? (Gasoline, Diesel)");
                    FossilFuelType ft = FossilFuelType.valueOf(scn.nextLine());

                    return new FossilFuelTruck(vin, make, model, year, rating, ed,
                            ft);
                }
                break;

            case Vehicle.TYPE_MOTORCYCLE:
                if (vstype.equals(Vehicle.SUBTYPE_FOSSIL_FUEL)) {
                    System.out.println("Weight (in Kg)");
                    int weight = Integer.parseInt(scn.nextLine());

                    System.out.println("Engine Displacement in Liters?");
                    double ed = Double.parseDouble(scn.nextLine());

                    System.out.println("Frontal Area (in Sq. M)?");
                    double frontalAreaSqM = Double.parseDouble(scn.nextLine());

                    return new FossilFuelMotorcycle(vin, make, model, year, weight, ed, frontalAreaSqM);
                }
                break;
        }

        throw new IllegalArgumentException();
    }
}
