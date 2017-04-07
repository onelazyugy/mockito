package com.le.viet.mockito.bank;

import org.springframework.stereotype.Service;

/**
 * Created by onelazyguy on 4/6/17.
 */
@Service
public class SavingAccount implements Account{
    @Override
    public void doDeposit(float amount) {

    }

    @Override
    public void doWithdrawal(float amount) {

    }

    @Override
    public float doBalanceInquiry(int account) {
        return 0;
    }
}
