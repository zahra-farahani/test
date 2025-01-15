package com.example.review.mapper.impl;

import com.example.review.dto.request.ProductProviderRequest;
import com.example.review.entity.Product;
import com.example.review.entity.ProductProvider;
import com.example.review.mapper.ProductProviderMapper;
import com.example.review.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductProviderMapperImpl implements ProductProviderMapper {
    private final ProviderService providerService;

    @Override
    public ProductProvider toEntity(Product product, ProductProviderRequest request) {
        return ProductProvider.builder()
                .product(product)
                .provider(providerService.fetchProviderById(request.getProviderId()))
                .reviewVisibility(request.getReviewVisibility())
                .isRatingEnabled(request.getIsRatingEnabled())
                .isCommentEnabled(request.getIsCommentEnabled())
                .price(request.getPrice())
                .build();
    }
}
