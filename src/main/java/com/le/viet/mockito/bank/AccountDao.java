package com.le.viet.mockito.bank;

/**
 * Created by onelazyguy on 4/7/17.
 */
public interface AccountDao {
    int queryBalance(int accountNbr);
    void deposit(float amount);
    void withdrawal(float amount) throws AccountException;
}
