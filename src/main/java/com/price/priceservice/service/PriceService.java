package com.price.priceservice.service;

import com.price.priceservice.service.response.PriceResponse;

import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * The PriceService interface provides methods for retrieving pricing details.
 */
public interface PriceService {

    /**
     * Retrieves the pricing details for a given application date, product ID, and brand ID.
     *
     * @param applicationDate The application date for which pricing details are requested.
     * @param productId       The ID of the product for which pricing details are requested.
     * @param brandId         The ID of the brand for which pricing details are requested.
     * @return The PriceResponse object containing the pricing details.
     */
    PriceResponse getPricingDetails(LocalDateTime applicationDate, BigInteger productId, Integer brandId);

}