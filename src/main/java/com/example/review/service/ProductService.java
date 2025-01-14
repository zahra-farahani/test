package com.example.review.service;

import com.example.review.dto.request.AssignProviderRequest;
import com.example.review.dto.request.CreateProductRequest;
import com.example.review.dto.response.BaseResponse;
import com.example.review.dto.response.ProductWithProviderResponse;

import java.util.List;

public interface ProductService {
    BaseResponse addProduct(CreateProductRequest request);

    List<ProductWithProviderResponse> getAllProducts();

    ProductWithProviderResponse getProductDetails(Long productId, Long providerId);

    void assignProvidersToExistingProduct(List<AssignProviderRequest> providers);
}
