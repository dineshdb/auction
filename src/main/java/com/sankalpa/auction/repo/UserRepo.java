package com.sankalpa.auction.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sankalpa.auction.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
