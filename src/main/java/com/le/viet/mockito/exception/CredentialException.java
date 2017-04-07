package com.le.viet.mockito.exception;

/**
 * Created by onelazyguy on 4/6/17.
 */
public class CredentialException extends Exception{
    private String message;
    private int exceptionCd;

    public CredentialException(String message, int exceptionCd){
        super(message);
        this.exceptionCd = exceptionCd;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getExceptionCd() {
        return exceptionCd;
    }

    public void setExceptionCd(int exceptionCd) {
        this.exceptionCd = exceptionCd;
    }
}
