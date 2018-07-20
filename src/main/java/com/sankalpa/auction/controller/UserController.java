package com.sankalpa.auction.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sankalpa.auction.model.User;
import com.sankalpa.auction.repo.UserRepo;

@RestController
@RequestMapping("/users")
public class UserController {
        private UserRepo userRepo;
        private BCryptPasswordEncoder passwdEncoder;
        
        public UserController(UserRepo applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = applicationUserRepository;
        this.passwdEncoder = bCryptPasswordEncoder;
    }
    
    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(passwdEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }
    
}
