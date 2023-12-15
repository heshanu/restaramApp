package com.restaturant.restaturant.springboot.repo;

import com.restaturant.restaturant.springboot.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<CategoryEntity, Long> {
}
