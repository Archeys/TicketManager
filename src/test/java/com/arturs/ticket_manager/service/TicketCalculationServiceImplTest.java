package com.arturs.ticket_manager.service;

import com.arturs.ticket_manager.data.dto.PassengerPricing;
import com.arturs.ticket_manager.data.dto.PriceViewModel;
import com.arturs.ticket_manager.data.dto.PriceRequest;
import com.arturs.ticket_manager.data.models.Passenger;
import com.arturs.ticket_manager.data.models.PassengerType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TicketCalculationServiceImplTest {
    @Qualifier("ticketCalculationServiceImpl")
    @Autowired
    private TicketCalculationService ticketCalculationService;

    @Test
    void withBaseTestScenario_shouldCalculateCorrectOutcome() {
        Passenger adult = new Passenger(PassengerType.ADULT, 2);
        Passenger child = new Passenger(PassengerType.CHILD, 1);
        List<Passenger> passengerList = new ArrayList<>();
        passengerList.add(adult);
        passengerList.add(child);
        PriceRequest priceRequest = new PriceRequest(passengerList);

        PriceViewModel priceModel = ticketCalculationService.getTicketPricing(priceRequest);
        PassengerPricing adultPricing = priceModel.getPassengerPricingList().get(0);
        PassengerPricing childPricing = priceModel.getPassengerPricingList().get(1);

        assertEquals(2, priceModel.getPassengerPricingList().size());
        assertEquals(12.10, adultPricing.getTicketTotal(), "Adult ticket price should be 12.10");
        assertEquals(7.26, adultPricing.getBagTotal(), "Adult bag total price should be 7.26");
        assertEquals(6.05, childPricing.getTicketTotal(), "Child ticket price should be 6.05");
        assertEquals(3.63, childPricing.getBagTotal(), "Child bag total price should be 3.63");
        assertEquals(29.04, priceModel.getPricingTotal(), "Total should be 29.04");
    }

}