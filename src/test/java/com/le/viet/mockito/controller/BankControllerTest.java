package com.le.viet.mockito.controller;

import com.le.viet.mockito.bank.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

/**
 * Created by onelazyguy on 4/10/17.
 * https://www.youtube.com/watch?v=gpG1ltXM8CQ
 */
@RunWith(SpringJUnit4ClassRunner.class)
//test spring mvc controller or spring controller, limit scan bean by controller only not other beans
@WebMvcTest(BankController.class)
public class BankControllerTest {
    @Autowired
    private MockMvc mvc;
    //mockito annotation
    @MockBean
    private AccountService accountService;

    @Test
    public void getAccountNbrTest() throws Exception{
        int id = 6;
        //similar to when then return, specify the behavior
        given(accountService.getAccountNbr(id)).willReturn("0000999");
        RequestBuilder requestBuilder = get("/rs/getAccountNbr/{id}", id);
        ResultActions resultActions = mvc.perform(requestBuilder);
        resultActions.andExpect(status().isOk()).andExpect(content().string("0000999"));
        verify(accountService, atLeastOnce()).getAccountNbr(id);
    }

    @Test
    public void getBalanceTest() throws Exception{
        float given = 12f;
        given(accountService.getBalance()).willReturn(given);
        MvcResult result = mvc.perform(get("/rs/getBalance")).andExpect(status().isOk()).andReturn();
        float expected = Float.parseFloat(result.getResponse().getContentAsString());
        assertEquals(expected, given, 0);
        verify(accountService, atLeastOnce()).getBalance();
    }
}
