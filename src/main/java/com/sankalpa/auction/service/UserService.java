package com.sankalpa.auction.service;

import com.sankalpa.auction.model.User;
import com.sankalpa.auction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User addUser(User newUser){
        return userRepository.save(newUser);
    }

    public User updateUser(User updatedUser){
        return userRepository.save(updatedUser);
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

    public User getUser(Long userId){
        return userRepository.findById(userId).orElse(null);
    }
}
