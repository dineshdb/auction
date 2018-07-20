package com.sankalpa.auction.model;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;
import com.sankalpa.auction.model.User;
import com.sankalpa.auction.repo.UserRepo;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepo applicationUserRepository;

    public UserDetailsServiceImpl(UserRepo applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User applicationUser = applicationUserRepository.findByUserName(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(applicationUser.getUserName(), applicationUser.getPassword(), emptyList());
    }
}
