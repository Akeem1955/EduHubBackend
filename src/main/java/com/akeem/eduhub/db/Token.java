package com.akeem.eduhub.db;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Token {
    @Id
    private String id;
    private String token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
