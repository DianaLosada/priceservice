package com.price.priceservice.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @NotNull
    private Brand brand;
    
    @NotNull
    private LocalDateTime startDate;
    
    @NotNull
    private LocalDateTime endDate;
    
    @NotNull
    private Integer priceList;
    
    @NotNull
    private BigInteger productId;
    
    @NotNull
    private Integer priority;
    
    @NotNull
    private BigDecimal price;
    
    @Column(length = 3)
    @NotNull
    private String curr;
}
