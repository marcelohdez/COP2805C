package edu.mdc.cop2805c.assignment1.base;

public enum FuelType {
    Gasoline,
    Diesel;

    public int getTruckEfficiencyConstant() {
        switch (this) {
            case Gasoline:
                return 10;
            case Diesel:
                return 14;
        }
        throw new IllegalArgumentException("Unknown FuelType used");
    }

    public int getCO2EmissionFactor(VehicleType vehicleType) {
        switch (this) {
            case Gasoline:
                switch (vehicleType) {
                    case Car:
                        return 8887;
                    case Truck:
                        return 11100;
                    case Motorcycle:
                        return 4600;
                }
                break;
            case Diesel:
                switch (vehicleType) {
                    case Car:
                        return 8260;
                    case Truck:
                        return 10250;
                    // no diesel motorcycle
                }
                break;
        }

        throw new IllegalArgumentException(
                String.format("CO2 emission factor unsupported for %s and %s", this.name(), vehicleType.name()));
    }

    public double getNOxEmissionFactor(VehicleType vehicleType) {
        switch (this) {
            case Gasoline:
                switch (vehicleType) {
                    case Car:
                        return 0.68;
                    case Truck:
                        return 2.10;
                    case Motorcycle:
                        return 3.20;
                }
                break;
            case Diesel:
                switch (vehicleType) {
                    case Car:
                        return 2.01;
                    case Truck:
                        return 4.60;
                    // no diesel motorcycle
                }
        }

        throw new IllegalArgumentException(
                String.format("NOx emission factor unsupported for %s and %s", this.name(), vehicleType.name()));
    }
}
