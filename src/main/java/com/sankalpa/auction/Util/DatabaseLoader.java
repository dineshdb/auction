package com.sankalpa.auction.Util;

import com.sankalpa.auction.model.*;
import com.sankalpa.auction.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        // add a list of common states an item can be in
        stateRepository.save(new State("LIVE"));
        stateRepository.save(new State("READY"));
        stateRepository.save(new State("SOLD"));

        // add a list of common categories an item can be associated with
        categoryRepository.save(new Category("Movie Prop"));
        categoryRepository.save(new Category("Painting"));
        categoryRepository.save(new Category("Antique"));
        categoryRepository.save(new Category("Gadget"));
        categoryRepository.save(new Category("Automobile"));
        categoryRepository.save(new Category("Jewellery"));

        adminRepository.save(new Admin("admin", passwordEncoder.encode("admin")));
        userRepository.save(new User("atosh502@gmail.com", passwordEncoder.encode("passw0rd")));
    }
}