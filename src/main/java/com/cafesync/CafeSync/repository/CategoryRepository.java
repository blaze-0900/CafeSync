package com.cafesync.CafeSync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cafesync.CafeSync.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}