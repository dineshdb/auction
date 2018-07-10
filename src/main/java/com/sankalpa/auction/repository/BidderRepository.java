package com.sankalpa.auction.repository;

import com.sankalpa.auction.model.Bidder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidderRepository extends JpaRepository<Bidder, Long> {
}
