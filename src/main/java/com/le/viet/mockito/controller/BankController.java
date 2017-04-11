package com.le.viet.mockito.controller;

import com.le.viet.mockito.bank.AccountService;
import com.le.viet.mockito.service.CredentialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by onelazyguy on 4/6/17.
 */
@RestController
//@RequestMapping("/rs")
public class BankController {
    private final Logger LOG = LoggerFactory.getLogger(BankController.class);
    public static final String GET_BALANCE_URL = "/getBalance";
    public static final String GET_ACCOUNT_NUMBER_URL = "/getAccountNbr/{id}";

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = GET_BALANCE_URL, method = RequestMethod.GET,  produces= MediaType.APPLICATION_JSON_VALUE)
    public float getBalance(){
        float balance = this.accountService.getBalance();
        return balance;
    }

    @RequestMapping(value = GET_ACCOUNT_NUMBER_URL, method = RequestMethod.GET)
    public String getAccountNbr(@PathVariable final int id){
        LOG.info("id: " + id);
        return this.accountService.getAccountNbr(id);
    }
}
