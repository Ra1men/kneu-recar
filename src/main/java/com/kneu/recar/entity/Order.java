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

public class Order {
    private Long id;
    private Client client;
    private Car car;
    private Administrator administrator;
    private String startDate;
    private String endDate;
    private String pickUpLocation;
    private String dropOffLocation;
    private BigDecimal totalPrice;
    private String status;
    private String rejectionReason;
}
