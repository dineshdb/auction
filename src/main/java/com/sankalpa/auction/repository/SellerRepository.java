package com.sankalpa.auction.repository;

import com.sankalpa.auction.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
