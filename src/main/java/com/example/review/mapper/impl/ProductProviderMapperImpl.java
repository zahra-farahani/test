package com.example.review.mapper.impl;

import com.example.review.dto.ProductDTO;
import com.example.review.entity.ProductProvider;
import com.example.review.mapper.ProductProviderMapper;
import com.example.review.mapper.ProviderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductProviderMapperImpl implements ProductProviderMapper {
//    private final ProviderMapper providerMapper;
//    @Override
//    public ProductDTO toProductDTO(ProductProvider productProvider) {
//        ProductDTO dto = new ProductDTO();
//        dto.setId(productProvider.getProduct().getId());
//        dto.setName(productProvider.getProduct().getName());
//        dto.setDescription(productProvider.getProduct().getDescription());
//        dto.setProvider(providerMapper.toProviderDTO(productProvider.getProvider()));
//    }
}
