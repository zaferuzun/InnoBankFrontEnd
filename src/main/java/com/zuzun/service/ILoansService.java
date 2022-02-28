package com.zuzun.service;

import com.zuzun.business.dto.AccountDto;
import com.zuzun.business.dto.CreateLoansDto;
import com.zuzun.business.dto.LoansDto;

public interface ILoansService {

    String sendAccountApi(CreateLoansDto createLoansDto);
    String sendLoansApi(CreateLoansDto createLoansDto,int accountId);

    CreateLoansDto getLoansAndAccountByTcNo(String tcNo);

    AccountDto getAccountByTcNo(String tcNo);
    LoansDto getLoastByAccountId(int accountId);


}
