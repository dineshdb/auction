package com.sankalpa.auction.repository;

import com.sankalpa.auction.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
