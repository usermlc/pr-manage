package com.await.productmanagementapp.repository;

import com.await.productmanagementapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

// Repository interface for managing Product entities
public interface ProductRepository extends JpaRepository<Product, Long>,
    JpaSpecificationExecutor<Product> {
    // Extends JpaRepository to provide standard CRUD operations
    // Extends JpaSpecificationExecutor to support dynamic queries with specifications
}
