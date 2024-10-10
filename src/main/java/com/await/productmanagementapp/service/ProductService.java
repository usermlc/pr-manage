package com.await.productmanagementapp.service;

import com.await.productmanagementapp.model.Product;
import com.await.productmanagementapp.repository.ProductRepository;
import com.await.productmanagementapp.specification.ProductSpecification;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service  // Marks this class as a service component in Spring for product-related operations
public class ProductService {

    private final ProductRepository productRepository;

    // Constructor for injecting the ProductRepository dependency
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Retrieves all products without filtering
    public List<Product> findAll() {
        return productRepository.findAll();  // Returns a list of all products
    }

    // Finds a product by its unique ID
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);  // Returns an Optional containing the product, if found
    }

    // Saves a new or existing product to the database
    public Product save(Product product) {
        return productRepository.save(product);  // Persists the product and returns the saved instance
    }

    // Deletes a product by its ID
    public void deleteById(Long id) {
        productRepository.deleteById(id);  // Removes the product from the database
    }

    // Finds products with optional filters: category, price range, and pagination support
    public Page<Product> findFilteredProducts(Long categoryId, BigDecimal minPrice, BigDecimal maxPrice, Pageable pageable) {
        // Builds a specification based on optional filters
        Specification<Product> spec = Specification.where(ProductSpecification.hasCategory(categoryId))
            .and(ProductSpecification.priceBetween(minPrice, maxPrice));

        return productRepository.findAll(spec, pageable);  // Returns a paginated list of products matching the specification
    }
}
