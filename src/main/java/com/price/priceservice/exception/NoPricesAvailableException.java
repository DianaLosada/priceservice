package com.price.priceservice.exception;

public class NoPricesAvailableException extends RuntimeException {
    public NoPricesAvailableException(String message) {
        super(message);
    }
}
