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

public class ReturnAct {
    private Long id;
    private Order order;
    private String returnDate;
    private String damages;
    private boolean hasDamages;
    private BigDecimal repairCost;
}
