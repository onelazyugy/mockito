package com.le.viet.mockito.service;

import com.le.viet.mockito.exception.CredentialException;

/**
 * Created by onelazyguy on 4/6/17.
 */
public interface CredentialService<T> {
    boolean doCredentialUpdate() throws CredentialException;
    void setCredentialRequest(T t);
}
