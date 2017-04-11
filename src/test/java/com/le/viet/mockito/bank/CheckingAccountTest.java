package com.le.viet.mockito.bank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by onelazyguy on 4/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CheckingAccountTest {
    @Mock
    AccountDao accountDaoImpl;

    @Test
    public void checkAcountDaoIsNotNull(){
        assertNotNull(accountDaoImpl);
    }

    @Test
    public void getCheckingAccountBalanceTest(){
        when(accountDaoImpl.queryBalance(123)).thenReturn(99);
        assertEquals(99, accountDaoImpl.queryBalance(123));
        //verifies that the methods (queryBalance) you called on your mocked object are indeed called
        verify(accountDaoImpl, atLeastOnce()).queryBalance(123);
    }

    @Test
    public void depositAnAmountToTheAccountTest(){
        doNothing().when(accountDaoImpl).deposit(99.99f);
        accountDaoImpl.deposit(99.99f);
        verify(accountDaoImpl, atLeastOnce()).deposit(99.99f);
    }

    @Test
    public void withdrawAnAmountFromAccountTest(){
        try {
            doNothing().when(accountDaoImpl).withdrawal(200f);
            accountDaoImpl.withdrawal(200f);
            verify(accountDaoImpl, times(1)).withdrawal(200f);
        }catch (AccountException ae){
            fail();
        }
    }

    @Test(expected = AccountException.class)
    public void withdrawAnAmountExceedBalanceTest() throws AccountException{
        doThrow(new AccountException("withdrawal amount exceeded current balance", 0)).when(accountDaoImpl).withdrawal(290.90f);
        accountDaoImpl.withdrawal(290.90f);
        verify(accountDaoImpl, atLeastOnce()).withdrawal(290.90f);
    }
}
