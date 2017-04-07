package com.le.viet.mockito.bank;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by onelazyguy on 4/7/17.
 */
@Service
public class AccountDaoImpl implements AccountDao{
    @Override
    public int queryBalance(int accountNbr) {
        Random random = new Random(12);
        int balance = random.nextInt(1000);
        return balance;
    }

    @Override
    public void deposit(float amount) {

    }

    @Override
    public void withdrawal(float amount) {

    }
}
