package com.github.ratel.services.impl;

import com.github.ratel.entity.User;
import com.github.ratel.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userService.findByLogin(username);
        return null;
    }


    public UserDetails loadUserById(Long id) throws AuthenticationException {
        return CustomUserDetails.create(this.userService.findUserById(id));
    }
}
