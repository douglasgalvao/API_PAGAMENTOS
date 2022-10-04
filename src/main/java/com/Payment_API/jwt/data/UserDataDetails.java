package com.Payment_API.jwt.data;

import com.Payment_API.entities.user.UserBank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class UserDataDetails implements UserDetails {

    private final Optional<UserBank> userBank;

    public UserDataDetails(Optional<UserBank> userBank) {
        this.userBank = userBank;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return userBank.orElse(new UserBank()).getPassword();
    }

    @Override
    public String getUsername() {
        return userBank.orElse(new UserBank()).getLogin();
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
}
