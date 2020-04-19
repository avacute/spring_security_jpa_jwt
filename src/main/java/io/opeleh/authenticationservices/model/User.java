package io.opeleh.authenticationservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="users", schema = "core")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    private String username;

    private String password;

    public User(long userID, String userName, String password) {
        this.userid= userID;
        this.username = userName;
        this.password = password;
    }

    public User() {
        
    }

    public long getUserID() {
        return userid;
    }

    public void setUserID(long userID) {
        this.userid = userID;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
       this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [userID=" + userid + ", password=" + password + ", username=" + username + "]";
    }

}