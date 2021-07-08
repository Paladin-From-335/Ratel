package com.github.ratel.security;

import com.github.ratel.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CustomUserDetails implements UserDetails {

    private final Optional<User> user;

    private final Collection<? extends GrantedAuthority> grantedAuthorities;

    public CustomUserDetails(Optional<User> user, Collection<? extends GrantedAuthority> grantedAuthorities) {
        this.user = user;
        this.grantedAuthorities = grantedAuthorities;
    }

    public static UserDetails create(Optional<User> user) {
        List<SimpleGrantedAuthority> grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(user.get().getRole().toString()));
        return new CustomUserDetails(user, grantedAuthorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.user.get().getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.get().getLogin();
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
