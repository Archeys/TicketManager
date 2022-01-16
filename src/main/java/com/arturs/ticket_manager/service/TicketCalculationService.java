package com.arturs.ticket_manager.service;

import com.arturs.ticket_manager.data.dto.PriceViewModel;
import com.arturs.ticket_manager.data.dto.PriceRequest;
import org.springframework.stereotype.Component;

@Component
public interface TicketCalculationService {
    PriceViewModel getTicketPricing(PriceRequest priceRequest);
}
