package com.sankalpa.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;
import com.sankalpa.auction.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userService.findbyEmail(userEmail);
        if (user == null) {
            throw new UsernameNotFoundException(userEmail);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserEmail(),
                user.getUserPassword(), emptyList());
    }
}
