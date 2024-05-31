package edu.mdc.cop2805c.assignment1.base;

public enum TransmissionType {
    AUTOMATIC(1),
    MANUAL(2);

    private final int ordinal;

    TransmissionType(int ordinal) {
        this.ordinal = ordinal;
    }

    public static TransmissionType valueOf(int ordinal) {
        switch (ordinal) {
            case 1:
                return AUTOMATIC;
            case 2:
                return MANUAL;
        }

        throw new IllegalArgumentException("Unknown ordinal");
    }

    public int getOrdinal() {
        return ordinal;
    }

    public double getMultiplier() {
        switch (this) {
            case AUTOMATIC:
                return 1;
            case MANUAL:
                return 0.8;
        }

        throw new IllegalArgumentException("Unknown TransmissionType used");
    }
}
