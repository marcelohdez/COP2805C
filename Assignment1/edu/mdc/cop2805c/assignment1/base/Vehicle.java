package edu.mdc.cop2805c.assignment1.base;

public abstract class Vehicle {
    public static final String TYPE_CAR = "Car";
    public static final String TYPE_TRUCK = "Truck";
    public static final String TYPE_MOTORCYCLE = "Motorcycle";

    public static final String SUBTYPE_ELECTRIC = "Electric";
    public static final String SUBTYPE_FOSSIL_FUEL = "Fossil Fuel";

    protected String vin;
    protected String make;
    protected String model;
    protected int year;

    public abstract String getVehicleType();

    public abstract String getVehicleSubType();

    public abstract String getDescription();
}
