package com.mg_devjoint.auth_service.security;

import com.mg_devjoint.auth_service.model.User;
import com.mg_devjoint.auth_service.service.UserService;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     User user =   userService.findUserByEmail(username);

     return new CustomUserDetails(user);

    }
}
