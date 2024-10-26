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
    private String startDate;
    private String endDate;
    private BigDecimal totalPrice;
    private String status;
    private String rejectionReason;
    private Payment payment;
    private ReturnAct returnAct;
}
