package com.fun7.backend.security;

public enum AdminPermission {
    USERS_READ("user:read"),
    USERS_DELETE("user:write");

    private final String permission;

    AdminPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
