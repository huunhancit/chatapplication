package com.tma.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dhnhan on 7/2/15.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    private long id;
    private String username;
    private String password;
    private String email;

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    @Id
    @GeneratedValue
    @Column(name = "username_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
