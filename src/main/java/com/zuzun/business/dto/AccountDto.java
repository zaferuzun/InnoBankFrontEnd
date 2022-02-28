package com.zuzun.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

    private int id;
    private String name;
    private String surname;
    private String tcNo;
    private String phone;
    private String birthday;
    private Long salary;


}
