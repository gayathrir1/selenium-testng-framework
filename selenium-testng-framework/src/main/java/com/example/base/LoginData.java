package com.example.base;

public class LoginData {
    private String username;
    private String password;
    private boolean expectedSuccess;

    // Getters
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public boolean isExpectedSuccess() { return expectedSuccess; }

    // Setters
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setExpectedSuccess(boolean expectedSuccess) { this.expectedSuccess = expectedSuccess; }
}
