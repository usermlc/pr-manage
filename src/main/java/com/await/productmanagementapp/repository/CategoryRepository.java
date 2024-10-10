package com.await.productmanagementapp.repository;

import com.await.productmanagementapp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for performing CRUD operations on Category entities
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Extends JpaRepository to provide built-in methods for data access
    // No additional code needed as JpaRepository includes basic CRUD operations
}
