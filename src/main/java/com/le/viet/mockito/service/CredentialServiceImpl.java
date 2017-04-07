package com.le.viet.mockito.service;

import com.le.viet.mockito.exception.CredentialException;
import com.le.viet.mockito.model.PasswordRequest;
import org.springframework.stereotype.Service;

/**
 * Created by onelazyguy on 4/6/17.
 */
@Service
public class CredentialServiceImpl implements CredentialService<PasswordRequest>{
    private PasswordRequest passwordRequest;

    @Override
    public boolean doCredentialUpdate() throws CredentialException {
        this.passwordRequest.setPassword("123updated");
        this.passwordRequest.setConfirmPassword("123updated");
        return true;
    }

    @Override
    public void setCredentialRequest(PasswordRequest passwordRequest) {
        this.passwordRequest = passwordRequest;
    }
}
