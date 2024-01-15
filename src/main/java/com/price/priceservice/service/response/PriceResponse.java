 package com.price.priceservice.service.response;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PriceResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer brandId;
    private BigInteger productId;
    private Integer priceList;
    private String startDate;
    private String endDate;
    private BigDecimal price;

}
