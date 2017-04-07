package com.le.viet.mockito.bank;

/**
 * Created by onelazyguy on 4/6/17.
 */
public interface Account {
    void doDeposit(float amount);
    void doWithdrawal(float amount);
    float doBalanceInquiry(int account);
}
