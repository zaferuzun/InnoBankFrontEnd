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
        LoansParameterModel loansParameterModel= LoansParameterModel.builder()
                        .accountSalary(createLoansDto.getSalary())
                        .accountScore(createLoansDto.getScore())
                        .build();
        LoansDto loansDto =LoansDto.builder()
                .type(createLoansDto.getType())
                .accountId(accountId)
                .build();
        if(createLoansDto.getMortgage()!=null && createLoansDto.getMortgage()!=0)
            loansParameterModel.setMortgage(createLoansDto.getMortgage());
        else
            loansParameterModel.setMortgage(createLoansDto.getMortgage());

        loansDto.setLoansParameterModel(loansParameterModel);

        LoansDto responseLoans = restTemplate.postForObject(baseUrl+"/loans/save", loansDto, LoansDto.class);


        return null;
    }

    @Override
    public CreateLoansDto getLoansAndAccountByTcNo(String tcNo) {
        AccountDto accountDto=getAccountByTcNo(tcNo);
        LoansDto loansDto = getLoastByAccountId(accountDto.getId());

        CreateLoansDto createLoansDto =CreateLoansDto.builder()
                .birthday(accountDto.getBirthday())
                .name(accountDto.getName())
                .mortgage(loansDto.getLoansParameterModel().getMortgage())
                .phone(accountDto.getPhone())
                .salary(accountDto.getSalary())
                .score(loansDto.getLoansParameterModel().getAccountScore())
                .surname(accountDto.getSurname())
                .tcNo(accountDto.getTcNo())
                .type(loansDto.getType())
                .build();
        if(loansDto.getApproval())
            createLoansDto.setApproval("Başarılı");
        else
            createLoansDto.setApproval("Başarısız");
        return createLoansDto;
    }

    @Override
    public AccountDto getAccountByTcNo(String tcNo) {
        return restTemplate.postForObject(baseUrl+"/account?tcNo="+tcNo, tcNo, AccountDto.class);
    }

    @Override
    public LoansDto getLoastByAccountId(int accountId) {
        return restTemplate.postForObject(baseUrl+"/loans?id="+accountId, accountId, LoansDto.class);
    }


}
