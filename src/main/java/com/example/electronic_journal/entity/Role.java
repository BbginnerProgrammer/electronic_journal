package com.example.electronic_journal.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN, TEACHER;

    @Override
    public String getAuthority() {
        return name();
    }

}
