package com.price.priceservice.service;

import com.price.priceservice.service.response.PriceResponse;

import java.math.BigInteger;
import java.time.LocalDateTime;


public interface PriceService {

    PriceResponse getPricingDetails(LocalDateTime applicationDate, BigInteger productId, Integer brandId);

}