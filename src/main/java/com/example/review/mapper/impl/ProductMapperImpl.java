package com.example.review.mapper.impl;

import com.example.review.dto.ProductDTO;
import com.example.review.dto.request.CreateProductRequest;
import com.example.review.entity.Product;
import com.example.review.entity.ProductProvider;
import com.example.review.mapper.ProductMapper;
import com.example.review.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapperImpl implements ProductMapper {
    private final ProviderService providerService;
    private final Predicate<List> isListEmpty = l -> Objects.nonNull(l) && !l.isEmpty();

    @Override
    public Product toEntity(CreateProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        if (isListEmpty.negate().test(productRequest.getProviders())) {
            product.setProductProviders(productRequest.getProviders().stream()
                    .map(provider -> ProductProvider.builder()
                            .product(product)
                            .provider(providerService.fetchProvider(provider.getId()))
                            .reviewVisibility(provider.getReviewVisibility())
                            .isRatingEnabled(provider.getIsRatingEnabled())
                            .isCommentEnabled(provider.getIsCommentEnabled())
                            .price(provider.getPrice())
                            .build())
                    .collect(Collectors.toSet()));
        }
        return product;
    }

    @Override
    public Product toEntity(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDTO.getId() );
        product.setName( productDTO.getName() );
        product.setDescription( productDTO.getDescription() );

        return product;
    }
}
