package com.zuzun.controller;

import com.zuzun.business.dto.CreateLoansDto;
import lombok.extern.log4j.Log4j2;
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

    //login ve register için get sayfası
    // http://localhost:8081/loans
    @GetMapping("/loans")
    public String getLoans(Model model){
        model.addAttribute("loans_form", new CreateLoansDto());
        return "loans";
    }
    // http://localhost:8081/loans
    @PostMapping("/loans")
    public String postLoans(@Valid @ModelAttribute("loans_form") CreateLoansDto createLoansDto, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("Hata var");
            log.info(createLoansDto);
            return "login";
        }

        //databaseden kontrol edilecek alan
        return "loans";
    }


}
