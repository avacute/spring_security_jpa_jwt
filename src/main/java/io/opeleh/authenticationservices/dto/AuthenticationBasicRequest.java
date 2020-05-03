package io.opeleh.authenticationservices.dto;

public class AuthenticationBasicRequest {

    private String username;
    private String password;

    public AuthenticationBasicRequest() {
    }

    public AuthenticationBasicRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthenticationBasicRequest [password=" + password + ", username=" + username + "]";
    }

    

}