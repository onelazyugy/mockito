package com.le.viet.mockito.controller;

import com.le.viet.mockito.bank.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/getAccountNbr/{id}", method = RequestMethod.GET)
    public String getAccountNbr(@PathVariable final int id){
        LOG.info("id: " + id);
        return this.accountService.getAccountNbr(id);
    }
}
