package com.le.viet.mockito.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by onelazyguy on 4/6/17.
 */
@Service
public class AccountService {
    private final Logger LOG = LoggerFactory.getLogger(AccountService.class);
    @Autowired
    private Account savingAccount;
    @Autowired
    private Account checkingAccount;

    public float getBalance(){
        return this.checkingAccount.doBalanceInquiry(2345);
    }

    public String getAccountNbr(int id){
        LOG.info("id: " + id);
        return id == 6 ? "0000999" : "no account found for give id: " + id;
    }
}