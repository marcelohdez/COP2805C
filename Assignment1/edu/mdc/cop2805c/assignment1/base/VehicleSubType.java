package edu.mdc.cop2805c.assignment1.base;

public enum VehicleSubType {
    Electric,
    Fossil_Fuel;

    @Override
    public String toString() {
        return name().replaceAll("_", " ");
    }

    public static VehicleSubType smartValueOf(String s) {
        return VehicleSubType.valueOf(s.replaceAll(" ", "_"));
    }
}
