package edu.mdc.cop2805c.assignment1.base;

public enum FuelType {
    GASOLINE,
    DIESEL;

    public int getTruckEfficiencyConstant() {
        switch (this) {
            case GASOLINE: return 10;
            case DIESEL: return 14;
        }
        throw new IllegalArgumentException("Unknown FuelType used");
    }

    public int getCO2EmissionFactor(VehicleType vehicleType) {
        switch (this) {
            case GASOLINE:
                switch (vehicleType) {
                    case CAR: return 8887;
                    case TRUCK: return 11100;
                    case MOTORCYCLE: return 4600;
                }
                break;
            case DIESEL:
                switch (vehicleType) {
                    case CAR: return 8260;
                    case TRUCK: return 10250;
                    // no diesel motorcycle
                }
                break;
        }

        throw new IllegalArgumentException(
                String.format("CO2 emission factor unsupported for %s and %s", this.name(), vehicleType.name())
        );
    }

    public double getNOxEmissionFactor(VehicleType vehicleType) {
        switch (this) {
            case GASOLINE:
                switch (vehicleType) {
                    case CAR: return 0.68;
                    case TRUCK: return 2.10;
                    case MOTORCYCLE: return 3.20;
                }
                break;
            case DIESEL:
                switch (vehicleType) {
                    case CAR: return 2.01;
                    case TRUCK: return 4.60;
                    // no diesel motorcycle
                }
        }

        throw new IllegalArgumentException(
                String.format("NOx emission factor unsupported for %s and %s", this.name(), vehicleType.name())
        );
    }
}
