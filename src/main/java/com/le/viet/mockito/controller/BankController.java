package com.le.viet.mockito.controller;

import com.le.viet.mockito.bank.AccountService;
import com.le.viet.mockito.service.CredentialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by onelazyguy on 4/6/17.
 */
@RestController
@RequestMapping("/rs")
public class BankController {
    private final Logger LOG = LoggerFactory.getLogger(BankController.class);
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/getBalance", method = RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
    public float getBalance(){
        float balance = this.accountService.getBalance();
        return balance;
    }
}
