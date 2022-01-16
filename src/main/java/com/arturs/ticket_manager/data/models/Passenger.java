package com.arturs.ticket_manager.data.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Passenger {
    @Valid
    @NotNull(message = "Null values are not allowed for passenger type")
    private PassengerType passengerType;

    @Valid
    @Min(value = 0, message = "The bag amount must be positive")
    @NotNull(message = "Null values are not allowed for bag count")
    private int bagCount;

    public Passenger(PassengerType type, int bagCount) {
        passengerType = type;
        this.bagCount = bagCount;
    }
}
