package com.example.timesystem.Response;

import com.example.timesystem.Model.User;

public class LoginResponse {
    private User user;

    private  String message;

    private boolean success;

    public LoginResponse(User user, String message, boolean success) {
        this.user = user;
        this.message = message;
        this.success = success;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
