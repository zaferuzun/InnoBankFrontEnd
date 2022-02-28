package com.zuzun.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoansParameterModel {
    //account information
    private double accountSalary;
    private int accountScore ;
    private double mortgage;

}
