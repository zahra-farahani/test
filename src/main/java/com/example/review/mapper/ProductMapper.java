package com.example.review.mapper;

import com.example.review.dto.ProductDTO;
import com.example.review.dto.request.CreateProductRequest;
import com.example.review.entity.Product;

public interface ProductMapper {
    Product toEntity(ProductDTO productDTO);

    Product toEntity(CreateProductRequest productRequest);
}
