package me.marcelohdez.vehicle_mgmt.base;

public abstract class Vehicle {
    int vin;
    int year;
    String make;
    String model;

    public abstract VehicleType getVehicleType();
    public abstract VehicleSubType getVehicleSubType();
    public abstract String getDescription();
}
