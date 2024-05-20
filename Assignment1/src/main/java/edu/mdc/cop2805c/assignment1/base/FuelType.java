package edu.mdc.cop2805c.assignment1.base;

public enum FuelType {
    GASOLINE,
    DIESEL;

    public int getEfficiencyConstant() {
        switch (this) {
            case GASOLINE: return 10;
            case DIESEL: return 14;
        }
        throw new IllegalArgumentException("Unknown FuelType used");
    }

    public int getCO2EmissionFactor() {
        switch (this) {
            case GASOLINE: return 8887;
            case DIESEL: return 8260;
        }
        throw new IllegalArgumentException("Unknown FuelType used");
    }

    public double getNOxEmissionFactor() {
        switch (this) {
            case GASOLINE: return 0.68;
            case DIESEL: return 2.01;
        }
        throw new IllegalArgumentException("Unknown FuelType used");
    }
}
