package com.le.viet.mockito.bank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by onelazyguy on 4/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CheckingAccountTest {
    @Mock
    AccountDao accountDaoImpl;

    @Test
    public void getCheckingAccountBalanceTest(){

    }
}
