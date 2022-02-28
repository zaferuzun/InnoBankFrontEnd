package com.zuzun.service.impl;

import com.zuzun.business.dto.AccountDto;
import com.zuzun.business.dto.CreateLoansDto;
import com.zuzun.business.dto.LoansDto;
import com.zuzun.business.dto.LoansParameterModel;
import com.zuzun.controller.utils.RestUtils;
import com.zuzun.service.ILoansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoansServiceImpl implements ILoansService {

    @Autowired
    RestUtils restUtils;
    String baseUrl = "http://localhost:8080/api";

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public String sendAccountApi(CreateLoansDto createLoansDto) {
        AccountDto accountDto= AccountDto.builder()
                .name(createLoansDto.getName())
                .surname(createLoansDto.getSurname())
                .phone(createLoansDto.getPhone())
                .salary(createLoansDto.getSalary())
                .birthday(createLoansDto.getBirthday())
                .tcNo(createLoansDto.getTcNo())
                .build();

        AccountDto responseAccount = restTemplate.postForObject(baseUrl+"/account/save", accountDto, AccountDto.class);
//        Gson gson = new Gson();
//        AccountDto target2 = gson.fromJson(response, AccountDto.class);
        sendLoansApi(createLoansDto,responseAccount.getId());

        return null;
    }

    @Override
    public String sendLoansApi(CreateLoansDto createLoansDto,int accountId) {
        LoansDto loansDto =LoansDto.builder()
                .loansParameterModel
                        (LoansParameterModel.builder()
                                .accountSalary(createLoansDto.getSalary())
                                .accountScore(createLoansDto.getScore())
                                .mortgage(createLoansDto.getMortgage())
                                .build())
                .type(createLoansDto.getType())
                .accountId(accountId)
                .build();
        LoansDto responseLoans = restTemplate.postForObject(baseUrl+"/account/save", loansDto, LoansDto.class);


        return null;
    }
}
