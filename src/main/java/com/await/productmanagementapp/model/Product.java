package com.await.productmanagementapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import lombok.Data;

@Entity  // Indicates that this class is a JPA entity
@Data    // Lombok annotation to auto-generate getters, setters, and other utility methods
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generates a unique ID for each product
    private Long id;  // Unique identifier for the product

    private String name;  // Name of the product
    private BigDecimal price;  // Price of the product with BigDecimal for precision
    private String photo;  // URL or path to the product photo

    @ManyToOne  // Establishes a many-to-one relationship with the Category entity
    @JoinColumn(name = "category_id", nullable = false)  // Foreign key column for category reference
    private Category category;  // Category to which this product belongs
}
