package com.example.review.service.impl;

import com.example.review.dto.request.ProductProviderRequest;
import com.example.review.entity.Product;
import com.example.review.entity.ProductProvider;
import com.example.review.mapper.ProductProviderMapper;
import com.example.review.repository.ProductProviderRepository;
import com.example.review.service.ProductProviderService;
import com.example.review.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductProviderServiceImpl implements ProductProviderService {
    private final ProductService productService;
    private final ProductProviderMapper productProviderMapper;
    private final ProductProviderRepository productProviderRepository;

    @Override
    public void assignProvidersToExistingProduct(Long productId, List<ProductProviderRequest> providers) {
        Product product = productService.fetchProductById(productId);
        Set<ProductProvider> productProviders = providers.stream().map(p -> productProviderMapper.toEntity(product, p)).collect(Collectors.toSet());
        productProviderRepository.saveAll(productProviders);
    }
}
