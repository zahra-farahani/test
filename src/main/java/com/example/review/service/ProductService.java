package com.example.review.service;

import com.example.review.dto.ProductDTO;
import com.example.review.dto.request.CreateProductRequest;
import com.example.review.dto.response.BaseResponse;
import com.example.review.entity.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    BaseResponse addProduct(CreateProductRequest request);

    List<ProductDTO> getAllProducts(Pageable pageable);

    Product fetchProductById(Long id);
}
