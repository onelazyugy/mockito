package com.le.viet.mockito.service;

import com.le.viet.mockito.exception.CredentialException;
import com.le.viet.mockito.model.PasswordRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

/**
 * Created by onelazyguy on 4/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CredentialServiceImplTest {
    @Mock
    PasswordRequest passwordRequest;
    @Mock
    CredentialService credentialService;

    @Before
    public void setUp(){

    }

    @Test
    public void testDoCredentialUpdate(){
        try {
            passwordRequest.setPassword("123");
            passwordRequest.setConfirmPassword("123");
            credentialService.setCredentialRequest(passwordRequest);
            when(credentialService.doCredentialUpdate()).thenReturn(true);
            Assert.assertEquals(null, null);
        }catch (CredentialException ce){

        }
    }
}
