package com.price.priceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.price.priceservice.model.Price;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Repository interface for managing Price entities.
 */
@Repository
public interface PriceRepository extends JpaRepository<Price, BigInteger> {
    
    /**
     * Retrieves a list of prices based on the given product ID, brand ID, start date, and end date.
     * The prices are ordered by priority in descending order.
     *
     * @param productId  the ID of the product
     * @param brandId    the ID of the brand
     * @param startDate  the start date
     * @param endDate    the end date
     * @return a list of prices matching the given criteria
     */
    List<Price> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            BigInteger productId, Integer brandId, LocalDateTime startDate, LocalDateTime endDate);
}
