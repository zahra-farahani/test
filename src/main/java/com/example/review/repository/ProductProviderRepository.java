package com.example.review.repository;

import com.example.review.entity.ProductProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductProviderRepository extends JpaRepository<ProductProvider, Long> {
    Optional<ProductProvider> findById_ProductIdAndId_ProviderId(Long productId, Long providerId);
}
