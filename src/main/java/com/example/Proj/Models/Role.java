package com.example.Proj.Models;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, SELLER, OTHER;

    @Override
    public String getAuthority() {
        return name();
    }
}
