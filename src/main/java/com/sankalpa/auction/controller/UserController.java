package com.sankalpa.auction.controller;

import com.sankalpa.auction.model.User;
import com.sankalpa.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private BCryptPasswordEncoder passwdEncoder;

    @Autowired
    private UserService userService;

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
    public @ResponseBody String signUp(@RequestBody User newUser) {
        newUser.setUserPassword(passwdEncoder.encode(newUser.getUserPassword()));
        // handle exception here
        try {
            User user = userService.addUser(newUser);
            return user.getUserId().toString();
        } catch (DataIntegrityViolationException e){
//            throw new UserAlreadyExistsException("A user with email "
//                    + newUser.getUserEmail() + " already exists.");
            return "A user with email " + newUser.getUserEmail() + " already exists.";
        }
    }

    @GetMapping("/{userId}/favorites")
    public @ResponseBody List<Long> favorites(@PathVariable Long userId){
        return userService.favorites(userId);
    }
}
