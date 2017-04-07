package com.le.viet.mockito.mock.service;

import com.le.viet.mockito.model.PasswordRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by onelazyguy on 4/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CredentialServiceImplTest {
    @Mock
    PasswordRequest passwordRequest;

    @Test
    public void testDoCredentialUpdate(){

    }
}
