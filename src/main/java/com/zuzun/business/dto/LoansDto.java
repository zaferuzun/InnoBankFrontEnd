package com.zuzun.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoansDto {
    private int id;
    private int accountId;
    private String type;
    private LoansParameterModel loansParameterModel;
}