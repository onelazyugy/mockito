package com.le.viet.mockito.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by onelazyguy on 4/6/17.
 */
@Service
public class CheckingAccount implements Account{
    @Autowired
    private AccountDao accountDaoImpl;

    @Override
    public void doDeposit(float amount) {
        accountDaoImpl.deposit(amount);
    }

    @Override
    public void doWithdrawal(float amount) {
        try{
            accountDaoImpl.withdrawal(99.50f);
        }catch (AccountException ae){
            ae.printStackTrace();
        }
    }

    @Override
    public float doBalanceInquiry(int account) {
        float balance = accountDaoImpl.queryBalance(account);
        return balance;
    }
}
