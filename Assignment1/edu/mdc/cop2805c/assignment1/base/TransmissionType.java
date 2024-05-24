package edu.mdc.cop2805c.assignment1.base;

public enum TransmissionType {
    Automatic(1),
    Manual(2);

    private final int ordinal;

    TransmissionType(int ordinal) {
        this.ordinal = ordinal;
    }

    public static TransmissionType valueOf(int ordinal) {
        switch (ordinal) {
            case 1:
                return Automatic;
            case 2:
                return Manual;
        }

        throw new IllegalArgumentException("Unknown ordinal");
    }

    public int getOrdinal() {
        return ordinal;
    }

    public double getMultiplier() {
        switch (this) {
            case Automatic:
                return 1;
            case Manual:
                return 0.8;
        }

        throw new IllegalArgumentException("Unknown TransmissionType used");
    }
}
