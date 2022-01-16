package com.arturs.ticket_manager.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class PriceViewModel {
    private ArrayList<PassengerPricing> passengerPricingList;
    private double pricingTotal;

    public PriceViewModel(ArrayList<PassengerPricing> passengerPricingList, double pricingTotal){
        this.passengerPricingList = passengerPricingList;
        this.pricingTotal = pricingTotal;
    }
}
