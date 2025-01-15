package com.example.review.mapper.impl;

import com.example.review.dto.ProductDTO;
import com.example.review.dto.request.CreateProductRequest;
import com.example.review.entity.Product;
import com.example.review.mapper.ProductMapper;
import com.example.review.mapper.ProductProviderMapper;
import com.example.review.mapper.ProviderMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapperImpl implements ProductMapper {
    private final ProductProviderMapper productProviderMapper;
    private final ProviderMapper providerMapper;

    @Override
    public Product toEntity(CreateProductRequest productRequest) {
        if (productRequest == null) {
            return null;
        }

        Product product = new Product();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        if (!CollectionUtils.isEmpty(productRequest.getProviders())) {
            product.setProductProviders(productRequest.getProviders().stream()
                    .map(provider -> productProviderMapper.toEntity(product, provider))
                    .collect(Collectors.toSet())
            );
        }
        return product;
    }

    @Override
    public Product toEntity(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }

        Product product = new Product();

        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());

        return product;
    }

    @Override
    public ProductDTO toDTO(Product product) {
        if (product == null) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());

        if (!CollectionUtils.isEmpty(product.getProductProviders())) {
            productDTO.setProviders(product.getProductProviders().stream().map(providerMapper::toDTO).toList());
        }

        return productDTO;
    }
}
