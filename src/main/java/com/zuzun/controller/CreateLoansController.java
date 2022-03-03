package com.zuzun.controller;

import com.zuzun.business.dto.AccountDto;
import com.zuzun.business.dto.CreateLoansDto;
import com.zuzun.service.ILoansService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class CreateLoansController {
    @Autowired
    ILoansService loansService;

    // http://localhost:8081/loans
    @GetMapping("/loans")
    public String getLoans(Model model){
        model.addAttribute("loans_form", new CreateLoansDto());
        return "./Home/View/loans";
    }
    // http://localhost:8081/loans
    @PostMapping("/loans")
    public String postLoans(@Valid @ModelAttribute("loans_form") CreateLoansDto createLoansDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("Hata var");
            log.info(createLoansDto);
            return "login";
        }
        loansService.sendAccountApi(createLoansDto);
        return "./Home/View/loans";
    }
    // http://localhost:8081/tcNo
    @GetMapping("/tcNo")
    public String getLoansByTcNo(Model model){
        model.addAttribute("tc_no", new AccountDto());
        model.addAttribute("loans_and_account", new CreateLoansDto());
        return "./Home/View/tcno";
    }

    //CreateLoansDto gösterilecek
    // http://localhost:8081/tcNo
    @PostMapping("/tcNo")
    public String postLoansByTcNo(@Valid @ModelAttribute("tc_no") AccountDto accountDto, BindingResult bindingResult,Model model){
        CreateLoansDto createLoansDto=loansService.getLoansAndAccountByTcNo(accountDto.getTcNo());
        model.addAttribute("loans_and_account", createLoansDto);
        return "./Home/View/tcno";
    }

    @GetMapping("/index")
    public String getIndex(){
        return "./Home/View/index";
    }




}
