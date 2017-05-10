package com.leonus96.joseph.siscolegio.Models;

/**
 * Created by joseph on 09/05/17.
 */

public class TokenManager {
    private String message;
    private String token;

    public TokenManager(String token, String message) {
        this.token = token;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
