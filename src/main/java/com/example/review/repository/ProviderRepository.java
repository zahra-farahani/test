package com.example.review.repository;

import com.example.review.entity.ProductProvider;
import com.example.review.entity.ProductProviderId;
import com.example.review.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {
}