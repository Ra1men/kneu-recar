package com.kneu.recar.entity;

import java.math.BigDecimal;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table("cars")
public class Car {

    @Id
    private Long id;
    private String brand;
    private String model;
    private int year;
    private BigDecimal pricePerDay;
    private String plateNumber;
}
