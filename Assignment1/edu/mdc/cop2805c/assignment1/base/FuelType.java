package edu.mdc.cop2805c.assignment1.base;

public enum FuelType {
    GASOLINE(1),
    DIESEL(2);

    private final int ordinal;

    FuelType(int ordinal) {
        this.ordinal = ordinal;
    }

    public static FuelType valueOf(int ordinal) {
        switch (ordinal) {
            case 1:
                return GASOLINE;
            case 2:
                return DIESEL;
        }

        throw new IllegalArgumentException("Unknown ordinal");
    }

    public int getOrdinal() {
        return ordinal;
    }

    public int getTruckEfficiencyConstant() {
        switch (this) {
            case GASOLINE:
                return 10;
            case DIESEL:
                return 14;
        }
        throw new IllegalArgumentException("Unknown FuelType used");
    }

    public int getCO2EmissionFactor(String vtype) {
        switch (this) {
            case GASOLINE:
                switch (vtype) {
                    case Vehicle.TYPE_CAR:
                        return 8887;
                    case Vehicle.TYPE_TRUCK:
                        return 11100;
                    case Vehicle.TYPE_MOTORCYCLE:
                        return 4600;
                }
                break;
            case DIESEL:
                switch (vtype) {
                    case Vehicle.TYPE_CAR:
                        return 8260;
                    case Vehicle.TYPE_TRUCK:
                        return 10250;
                    // no diesel motorcycle
                }
                break;
        }

        throw new IllegalArgumentException(
                "CO2 emission factor unsupported for " + this.name() + " and " + vtype);
    }

    public double getNOxEmissionFactor(String vtype) {
        switch (this) {
            case GASOLINE:
                switch (vtype) {
                    case Vehicle.TYPE_CAR:
                        return 0.68;
                    case Vehicle.TYPE_TRUCK:
                        return 2.10;
                    case Vehicle.TYPE_MOTORCYCLE:
                        return 3.20;
                }
                break;
            case DIESEL:
                switch (vtype) {
                    case Vehicle.TYPE_CAR:
                        return 2.01;
                    case Vehicle.TYPE_TRUCK:
                        return 4.60;
                    // no diesel motorcycle
                }
        }

        throw new IllegalArgumentException(
                "NOx emission factor unsupported for " + this.name() + " and %s" + vtype);
    }
}
