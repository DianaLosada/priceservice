package com.price.priceservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Brand {
    @Id
    private Integer id;
    @NotNull
    private String name;
}
