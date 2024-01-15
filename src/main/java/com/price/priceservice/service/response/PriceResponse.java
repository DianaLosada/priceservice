 package com.price.priceservice.service.response;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PriceResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private int brandId;
    private long productId;
    private int priceList;
    private String startDate;
    private String endDate;
    private float price;

}
