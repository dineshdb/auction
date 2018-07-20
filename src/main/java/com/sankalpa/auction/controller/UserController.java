package com.sankalpa.auction.controller;

import com.sankalpa.auction.model.User;
import com.sankalpa.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.sankalpa.auction.model.User;
import com.sankalpa.auction.repo.UserRepo;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
        private UserRepo userRepo;
        private BCryptPasswordEncoder passwdEncoder;
        

    @Autowired
    private UserService userService;

    public UserController(UserRepo applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = applicationUserRepository;
        this.passwdEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/")
    public @ResponseBody List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public @ResponseBody User getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }

    @PostMapping("/")
    public @ResponseBody User addUser(@RequestBody User newUser){
        return userService.addUser(newUser);
    }

    @PutMapping("/")
    public @ResponseBody User updateUser(@RequestBody User updatedUser){
        return userService.updateUser(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(passwdEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }
}
