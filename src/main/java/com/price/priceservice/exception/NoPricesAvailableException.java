package com.price.priceservice.exception;

/**
 * Exception thrown when no prices are available.
 */
public class NoPricesAvailableException extends RuntimeException {
    /**
     * Constructs a new NoPricesAvailableException with the specified detail message.
     *
     * @param message the detail message
     */
    public NoPricesAvailableException(String message) {
        super(message);
    }
}
