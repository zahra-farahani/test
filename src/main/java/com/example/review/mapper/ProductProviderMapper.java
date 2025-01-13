package com.example.review.mapper;

import com.example.review.dto.ProductDTO;
import com.example.review.entity.ProductProvider;

public interface ProductProviderMapper {
    ProductDTO toProductDTO(ProductProvider productProvider);
}
