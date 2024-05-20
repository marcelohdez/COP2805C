package edu.mdc.cop2805c.assignment1.base;

public enum TransmissionType {
    AUTOMATIC,
    MANUAL;

    public double getMultiplier() {
        switch (this) {
            case AUTOMATIC: return 1;
            case MANUAL: return 0.8;
        }
        throw new IllegalArgumentException("Unknown TransmissionType used");
    }
}
