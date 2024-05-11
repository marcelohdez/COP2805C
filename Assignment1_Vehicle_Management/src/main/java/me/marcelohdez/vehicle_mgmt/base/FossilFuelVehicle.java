package me.marcelohdez.vehicle_mgmt.base;

public interface FossilFuelVehicle {
    double estimateFuelEfficiency();
    double estimateCO2Emissions();
    double estimateNOxEmissions();
}
