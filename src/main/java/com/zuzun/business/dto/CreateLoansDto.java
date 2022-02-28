package com.zuzun.business.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class CreateLoansDto {

    private String name;
    private String surname;
    private String tcNo;
    private String phone;
    private String birthday;
    private Long salary;
    private String type;
    private int score;
    private double mortgage;


}
