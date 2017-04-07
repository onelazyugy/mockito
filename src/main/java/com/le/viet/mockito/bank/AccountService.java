package com.le.viet.mockito.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by onelazyguy on 4/6/17.
 */
@Service
public class AccountService {
    @Autowired
    private Account savingAccount;
    @Autowired
    private Account checkingAccount;

    public float getBalance(){
        return this.checkingAccount.doBalanceInquiry(2345);
    }
}