package com.le.viet.mockito.bank;

/**
 * Created by associate on 4/8/17.
 */
public class AccountException extends Exception{
    private String message;
    private int exceptionCd;

    public AccountException(String message, int exceptionCd){
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

    @Override
    public String toString() {
        return "AccountException{" +
                "message='" + message + '\'' +
                ", exceptionCd=" + exceptionCd +
                '}';
    }
}
