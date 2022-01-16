package com.arturs.ticket_manager.data.dto;

import com.arturs.ticket_manager.data.models.PassengerType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class PassengerPricing {
    private PassengerType passengerType;
    private int bagCount;
    private double bagTotal;
    @Min(value = 0, message = "Ticket total must be a positive value")
    private double ticketTotal;

    public PassengerPricing(PassengerType passengerType, int bagCount, double bagTotal, double ticketTotal) {
        this.passengerType = passengerType;
        this.bagCount = bagCount;
        this.bagTotal = bagTotal;
        this.ticketTotal = ticketTotal;
    }
}
