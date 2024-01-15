package com.price.priceservice.controller;

import java.math.BigInteger;
import java.time.LocalDateTime;

import com.price.priceservice.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.price.priceservice.service.response.PriceResponse;
import com.price.priceservice.service.PriceService;

/**
 * The PriceController class provides REST endpoints related to pricing information.
 */
@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    /**
     * Retrieves the pricing details for a given application date, product ID, and brand ID.
     *
     * @param applicationDate The application date in string format.
     * @param productId       The ID of the product.
     * @param brandId         The ID of the brand.
     * @return The ResponseEntity containing the PriceResponse with pricing details.
     */
    @GetMapping
    public ResponseEntity<PriceResponse> getPrice(@RequestParam String applicationDate,
                                                   @RequestParam BigInteger productId,
                                                   @RequestParam Integer brandId) {
        LocalDateTime date = DateUtils.convertStringToDate(applicationDate);
        PriceResponse response = priceService.getPricingDetails(date, productId, brandId);
        return ResponseEntity.ok(response);
    }
}