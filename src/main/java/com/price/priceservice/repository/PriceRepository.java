package com.price.priceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.price.priceservice.model.Price;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, BigInteger> {
    
    List<Price> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            BigInteger productId, Integer brandId, LocalDateTime startDate, LocalDateTime endDate);
}
