package com.sankalpa.auction.repository;

import com.sankalpa.auction.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
