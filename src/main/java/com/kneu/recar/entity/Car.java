package com.kneu.recar.entity;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Car {
    private Long id;
    private String brand;
    private String model;
    private int year;
    private BigDecimal pricePerDay;
    private String plateNumber;
}
