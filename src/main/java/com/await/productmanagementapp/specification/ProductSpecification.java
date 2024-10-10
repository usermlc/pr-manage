package com.await.productmanagementapp.specification;

import com.await.productmanagementapp.model.Product;
import java.math.BigDecimal;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    // Specification to filter products by category ID
    public static Specification<Product> hasCategory(Long categoryId) {
        return (root, query, criteriaBuilder) -> {
            if (categoryId == null) {
                return criteriaBuilder.conjunction();  // No filtering if categoryId is null
            }
            // Filters by category ID when it is provided
            return criteriaBuilder.equal(root.get("category").get("id"), categoryId);
        };
    }

    // Specification to filter products by a price range
    public static Specification<Product> priceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return (root, query, criteriaBuilder) -> {
            // If no price range is specified, returns all products
            if (minPrice == null && maxPrice == null) {
                return criteriaBuilder.conjunction();
            }
            // Filters products with price less than or equal to maxPrice
            else if (minPrice == null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
            }
            // Filters products with price greater than or equal to minPrice
            else if (maxPrice == null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            }
            // Filters products within the specified price range
            else {
                return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
            }
        };
    }
}
