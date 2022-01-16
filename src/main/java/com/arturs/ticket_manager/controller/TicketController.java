package com.arturs.ticket_manager.controller;

import com.arturs.ticket_manager.data.dto.PriceRequest;
import com.arturs.ticket_manager.service.TicketCalculationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@Validated
public class TicketController {
    private final TicketCalculationService ticketCalculationService;

    public TicketController(@Qualifier("ticketCalculationServiceImpl") TicketCalculationService _ticketCalculationServiceService) {
        this.ticketCalculationService = _ticketCalculationServiceService;
    }

    @PostMapping("/getTicketPricing")
    public @ResponseBody ResponseEntity getTicketPricing(@RequestBody @Valid PriceRequest request, BindingResult result, HttpServletResponse response) {
        return new ResponseEntity<>(ticketCalculationService.getTicketPricing(request), HttpStatus.OK);
    }
}
