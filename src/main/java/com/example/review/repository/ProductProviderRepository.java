package com.example.review.repository;

import com.example.review.entity.ProductProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductProviderRepository extends JpaRepository<ProductProvider, Long> {
}
