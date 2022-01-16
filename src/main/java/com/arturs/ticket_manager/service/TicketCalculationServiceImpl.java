package com.arturs.ticket_manager.service;

import com.arturs.ticket_manager.data.dto.PassengerPricing;
import com.arturs.ticket_manager.data.dto.PriceViewModel;
import com.arturs.ticket_manager.data.dto.PriceRequest;
import com.arturs.ticket_manager.data.models.Passenger;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;

@Service
public class TicketCalculationServiceImpl implements TicketCalculationService {
    private final double _baseTicketPrice = 10d;
    private final double _pvnPercentage = 0.21d;

    @Override
    public PriceViewModel getTicketPricing(@Valid PriceRequest priceRequest) {
        ArrayList<PassengerPricing> fullPricingList = new ArrayList<>();
        priceRequest.getPassengerList().forEach((passenger) -> {
            double ticketPrice = calculatePassengerTicketPrice(passenger);
            double totalBagPrice = calculatePassengerBagPrice(passenger.getBagCount());
            fullPricingList.add(new PassengerPricing(passenger.getPassengerType(), passenger.getBagCount(), totalBagPrice, ticketPrice));
        });
        return new PriceViewModel(fullPricingList);
    }

    private double calculatePassengerTicketPrice(Passenger passenger) {
        double priceWithDiscount = _baseTicketPrice * passenger.getPassengerType().getPassengerDiscount();
        return applyPVN(priceWithDiscount);
    }

    private double calculatePassengerBagPrice(int bagAmount) {
        double bagPrice = _baseTicketPrice * bagAmount * 0.3;
        return applyPVN(bagPrice);
    }

    private double applyPVN(double amount) {
        return amount += amount * _pvnPercentage;
    }

}
