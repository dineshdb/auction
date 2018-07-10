package com.sankalpa.auction.repository;

import com.sankalpa.auction.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
