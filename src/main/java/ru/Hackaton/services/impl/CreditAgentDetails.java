package ru.Hackaton.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.Hackaton.models.CreditAgent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class CreditAgentDetails implements UserDetails {
    private final CreditAgent creditAgent;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> roles = new ArrayList<>();

        roles.add(new SimpleGrantedAuthority("ROLE_AGENT"));

        if (creditAgent.isAdmin()) {
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }

        return roles;
    }

    @Override
    public String getPassword() {
        return creditAgent.getPassword();
    }

    @Override
    public String getUsername() {
        return creditAgent.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public CreditAgent getCreditAgent() {
        return creditAgent;
    }
}
