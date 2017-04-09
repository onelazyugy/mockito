package com.le.viet.mockito.bank;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by onelazyguy on 4/7/17.
 */
@Service
public class AccountDaoImpl implements AccountDao{
    private float CURRENT_BALANCE = 110.90f;

    @Override
    public int queryBalance(int accountNbr) {
        Random random = new Random(12);
        int balance = random.nextInt(1000);
        return balance;
    }

    @Override
    public void deposit(float amount) {
        CURRENT_BALANCE = CURRENT_BALANCE + amount;
    }

    @Override
    public void withdrawal(float amount) throws AccountException{
        if(amount > CURRENT_BALANCE){
            throw new AccountException("amount exceed current balance", 0);
        }
        CURRENT_BALANCE = CURRENT_BALANCE - amount;
    }
}
