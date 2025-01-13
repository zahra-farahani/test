package com.example.review.service.impl;

import com.example.review.dto.request.CreateProductRequest;
import com.example.review.dto.response.BaseResponse;
import com.example.review.dto.response.ProductWithProviderResponse;
import com.example.review.entity.Product;
import com.example.review.entity.ProductProvider;
import com.example.review.mapper.ProductMapper;
import com.example.review.repository.ProductProviderRepository;
import com.example.review.repository.ProductRepository;
import com.example.review.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductProviderRepository productProviderRepository;

    private final ProductMapper productMapper;

    @Override
    public BaseResponse addProduct(CreateProductRequest request) {
        Product product = productRepository.save(productMapper.toProductEntity(request));
        return new BaseResponse(product.getId());
    }

    @Override
    public List<ProductWithProviderResponse> getAllProducts() {
        List<ProductProvider> all = productProviderRepository.findAll();
        return null;
    }

    @Override
    public ProductWithProviderResponse getProductDetails(Long productId, Long providerId) {
        return null;
    }
}
