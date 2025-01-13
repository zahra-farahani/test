package com.example.review.mapper;

import com.example.review.dto.ProductDTO;
import com.example.review.dto.request.CreateProductRequest;
import com.example.review.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toProductDTO(Product product);

    Product toProductEntity(ProductDTO productDTO);

    Product toProductEntity(CreateProductRequest productRequest);
}
