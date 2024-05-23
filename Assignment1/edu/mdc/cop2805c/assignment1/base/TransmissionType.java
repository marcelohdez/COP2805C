package edu.mdc.cop2805c.assignment1.base;

public enum TransmissionType {
    Automatic,
    Manual;

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
