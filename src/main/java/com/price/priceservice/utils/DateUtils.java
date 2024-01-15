package com.price.priceservice.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {

    private static final DateTimeFormatter[] formatters = {
            DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss")
            // Add more formatters as needed
    };

    public static LocalDateTime convertStringToDate(String dateInString) {
        for (DateTimeFormatter formatter : formatters) {
            try {
                return LocalDateTime.parse(dateInString, formatter);
            } catch (DateTimeParseException e) {
                // Ignore and try the next formatter
            }
        }
        throw new IllegalArgumentException("Invalid date format: " + dateInString);
    }

}
