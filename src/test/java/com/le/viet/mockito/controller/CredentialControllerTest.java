package com.le.viet.mockito.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.le.viet.mockito.model.PasswordRequest;
import com.le.viet.mockito.model.PasswordResponse;
import com.le.viet.mockito.service.CredentialService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;
/**
 * Created by onelazyguy on 4/11/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CredentialController.class)
public class CredentialControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CredentialService credentialService;

    @Test
    public void testUpdatePassword() throws Exception{
        String requestJSON = "{\n" +
                "\t\"password\": \"what is my password\",\n" +
                "\t\"confirmPassword\": \"my confirmed password\"\n" +
                "}";
        given(credentialService.doCredentialUpdate()).willReturn(true);
        String URI = "/rs/updatePassword";
        MvcResult mvcResult = mockMvc.perform(post(URI).header("Content-Type", "application/json")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(requestJSON)).andDo(print())
                            .andExpect(status().isOk()).andReturn();
        String expectedJSON = mvcResult.getResponse().getContentAsString();
        PasswordResponse passwordResponse = new ObjectMapper().readValue(expectedJSON, PasswordResponse.class);
        assertNotNull(passwordResponse);
        assertTrue(passwordResponse.getMessage().equalsIgnoreCase("success"));
        verify(credentialService, atLeastOnce()).doCredentialUpdate();
    }
}
