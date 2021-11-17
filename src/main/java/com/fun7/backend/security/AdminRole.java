package com.fun7.backend.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.fun7.backend.security.AdminPermission.*;

public enum AdminRole {
    ADMIN(Sets.newHashSet(USERS_READ, USERS_DELETE));

    private final Set<AdminPermission> permissions;

    AdminRole(Set<AdminPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<AdminPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
