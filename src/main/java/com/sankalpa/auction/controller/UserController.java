package com.sankalpa.auction.controller;

import com.sankalpa.auction.model.User;
import com.sankalpa.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public @ResponseBody List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public @ResponseBody User getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }

    @PostMapping("/users")
    public @ResponseBody User addUser(@RequestBody User newUser){
        return userService.addUser(newUser);
    }

    @PutMapping("/users")
    public @ResponseBody User updateUser(@RequestBody User updatedUser){
        return userService.updateUser(updatedUser);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
