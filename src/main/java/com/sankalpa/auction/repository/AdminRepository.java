package com.sankalpa.auction.repository;

import com.sankalpa.auction.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
