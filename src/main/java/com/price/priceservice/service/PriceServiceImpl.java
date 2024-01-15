package com.price.priceservice.service;

import com.price.priceservice.service.response.PriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.price.priceservice.exception.NoPricesAvailableException;
import com.price.priceservice.model.Price;
import com.price.priceservice.repository.PriceRepository;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Implementation of the PriceService interface that provides pricing details.
 */
@Service
public class PriceServiceImpl implements PriceService {

    private static final int FIRST_PRICE = 0;
    private final PriceRepository priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceResponse getPricingDetails(LocalDateTime applicationDate, BigInteger productId, Integer brandId) {
        List<Price> prices = priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            productId, brandId, applicationDate, applicationDate);

        if (prices.isEmpty()) {
            throw new NoPricesAvailableException("No prices available for product " + productId + " and brand " + brandId
                                                 + " at " + applicationDate);
        }

        Price applicablePrice = prices.get(FIRST_PRICE);

        return new PriceResponse(applicablePrice.getBrand().getId().intValue(), applicablePrice.getProductId().longValue(),
                                 applicablePrice.getPriceList().intValue(), applicablePrice.getStartDate().format(DateTimeFormatter.ISO_DATE_TIME),
                                 applicablePrice.getEndDate().format(DateTimeFormatter.ISO_DATE_TIME), applicablePrice.getPrice().floatValue());
    }
}