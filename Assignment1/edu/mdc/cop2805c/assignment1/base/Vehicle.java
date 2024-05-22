package edu.mdc.cop2805c.assignment1.base;

public abstract class Vehicle {
    protected String vin;
    protected String make;
    protected String model;
    protected int year;

    public abstract String getVehicleType();

    public abstract String getVehicleSubType();

    public abstract String getDescription();
}
