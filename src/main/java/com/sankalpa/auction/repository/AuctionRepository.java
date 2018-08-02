package com.sankalpa.auction.repository;

import com.sankalpa.auction.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

    List<Auction> findAllByAuctionDate(LocalDate today);
}
