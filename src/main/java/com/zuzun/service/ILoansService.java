package com.zuzun.service;

import com.zuzun.business.dto.CreateLoansDto;

public interface ILoansService {

    String sendAccountApi(CreateLoansDto createLoansDto);
    String sendLoansApi(CreateLoansDto createLoansDto,int accountId);
}
