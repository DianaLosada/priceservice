package com.price.priceservice.converter;

import com.price.priceservice.model.Price;
import com.price.priceservice.service.response.PriceResponse;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class PriceConverter {
    public Optional<PriceResponse> convert(Price price) {
        if (price == null) {
            return Optional.empty();
        }

        PriceResponse priceResponse = new PriceResponse();
        priceResponse.setBrandId(price.getBrand().getId().intValue());
        priceResponse.setProductId(price.getProductId().longValue());
        priceResponse.setPriceList(price.getPriceList().intValue());
        priceResponse.setStartDate(price.getStartDate().format(DateTimeFormatter.ISO_DATE_TIME));
        priceResponse.setEndDate(price.getEndDate().format(DateTimeFormatter.ISO_DATE_TIME));
        priceResponse.setPrice(price.getPrice().floatValue());

        return Optional.of(priceResponse);
    }
}
