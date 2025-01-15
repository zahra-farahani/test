package com.example.review.mapper;


import com.example.review.dto.request.ProductProviderRequest;
import com.example.review.entity.Product;
import com.example.review.entity.ProductProvider;

public interface ProductProviderMapper {
    ProductProvider toEntity(Product product, ProductProviderRequest request);
}
