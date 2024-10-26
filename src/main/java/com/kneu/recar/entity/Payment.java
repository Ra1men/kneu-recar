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

public class Payment {
    private Long id;
    private Order order;
    private BigDecimal amount;
    private String paymentDate;
    private String status;
}
