package com.le.viet.mockito.controller;

import com.le.viet.mockito.bank.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    public void getBalanceTest() throws Exception{
        int id = 6;

        //given(accountService.getAccountNbr(id)).willReturn("0000999");

        RequestBuilder requestBuilder = get(BankController.GET_ACCOUNT_NUMBER_URL, id);
        ResultActions resultActions = mvc.perform(requestBuilder);
        resultActions.andExpect(status().isOk()).andExpect(content().string("0000999"));

        //mvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().string("0000999"));
        /*mvc.perform(get(BankController.GET_ACCOUNT_NUMBER_URL, id).accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status()
                .isOk()).andExpect(content().string("0000999"));*/
    }
}
