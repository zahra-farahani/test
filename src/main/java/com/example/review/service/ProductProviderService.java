package com.example.review.service;

import com.example.review.dto.request.ProductProviderRequest;

import java.util.List;

public interface ProductProviderService {
    void assignProvidersToExistingProduct(Long productId, List<ProductProviderRequest> providers);
}
