package com.await.productmanagementapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity  // Marks this class as a JPA entity
@Data    // Lombok annotation to generate getters, setters, and other utility methods
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Specifies auto-generation for the ID field
    private Long id;  // Unique identifier for each category

    private String name;  // Name of the category
}
