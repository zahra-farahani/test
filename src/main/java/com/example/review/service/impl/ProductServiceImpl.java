package com.example.review.service.impl;

import com.example.review.dto.ProductDTO;
import com.example.review.dto.ReviewStatsDTO;
import com.example.review.dto.request.CreateProductRequest;
import com.example.review.dto.response.BaseResponse;
import com.example.review.entity.Product;
import com.example.review.exception.ProductNotFoundException;
import com.example.review.mapper.ProductMapper;
import com.example.review.mapper.ReviewMapper;
import com.example.review.repository.ProductRepository;
import com.example.review.repository.ReviewRepository;
import com.example.review.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    @Transactional
    @Override
    public BaseResponse addProduct(CreateProductRequest request) {
        Product product = productRepository.save(productMapper.toEntity(request));
        return new BaseResponse(product.getId());
    }

    @Override
    public List<ProductDTO> getAllProducts(Pageable pageable) {
        List<ProductDTO> productDTOS = productRepository.findProductsWithDetails(pageable).map(productMapper::toDTO).toList();
        productDTOS.forEach(p -> {
            ReviewStatsDTO stats = reviewRepository.findReviewStatsByProductId(p.getId());
            p.setAvgRating(stats.getAverageRating());
            p.setTotalReviews(stats.getTotalReviews());

            if (stats.getTotalReviews() > 0) {
                p.setReviews(reviewRepository.findLastThreeReviewsByProductId(p.getId()).stream().map(reviewMapper::toReviewDTO).toList());
            }
        });
        return productDTOS;
    }

    @Override
    public Product fetchProductById(Long id) {
        return Optional.of(productRepository.findById(id)).get().orElseThrow(ProductNotFoundException::new);
    }
}
