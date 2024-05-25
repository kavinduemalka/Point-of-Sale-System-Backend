package com.posystem.posystem.repository;

import com.posystem.posystem.entity.ItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<ItemCategory, Long> {
}
