package com.arturs.ticket_manager.data.dto;

import com.arturs.ticket_manager.data.models.Passenger;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
@Getter
@Setter
public class PriceRequest {
    @JsonProperty("passengerList")
    @Valid
    private List<Passenger> passengerList;

    public PriceRequest(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    @JsonCreator
    public PriceRequest() {
    }
}
