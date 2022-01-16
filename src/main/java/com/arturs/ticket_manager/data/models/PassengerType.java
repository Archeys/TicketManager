package com.arturs.ticket_manager.data.models;

public enum PassengerType {
    ADULT,
    CHILD
    ;

    public double getPassengerDiscount() {
        if (this == PassengerType.CHILD) {
            return 0.5d;
        }
        return 1d;
    }
}
