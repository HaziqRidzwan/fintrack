package com.haziq.fintrack.repository;

import com.haziq.fintrack.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
