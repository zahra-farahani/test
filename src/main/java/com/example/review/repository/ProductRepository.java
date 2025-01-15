package com.example.review.repository;

import com.example.review.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
            SELECT p
            FROM Product p
            JOIN FETCH p.productProviders pp
            JOIN FETCH pp.provider p2
            ORDER BY p.createdAt DESC
            """)
    Page<Product> findProductsWithDetails(Pageable pageable);
}