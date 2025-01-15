package com.example.review.service.impl;

import com.example.review.dto.request.CreateReviewRequest;
import com.example.review.dto.response.BaseResponse;
import com.example.review.entity.Product;
import com.example.review.entity.Provider;
import com.example.review.entity.Review;
import com.example.review.entity.User;
import com.example.review.enumeration.ReviewStatus;
import com.example.review.mapper.ReviewMapper;
import com.example.review.repository.ReviewRepository;
import com.example.review.service.ProductService;
import com.example.review.service.ProviderService;
import com.example.review.service.ReviewService;
import com.example.review.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductService productService;
    private final ProviderService providerService;
    private final UserService userService;
    private final ReviewMapper reviewMapper;

    @Override
    public BaseResponse addReview(CreateReviewRequest request) {
        Product product = productService.fetchProductById(request.getProductId());
        Provider provider = providerService.fetchProviderById(request.getProviderId());
        User user = userService.fetchByUserId(request.getUserId());


        Review review = reviewMapper.toReviewEntity(request);
        review.setProduct(product);
        review.setProvider(provider);
        review.setUser(user);
        review.setStatus(ReviewStatus.PENDING);

        review = reviewRepository.save(review);
        return new BaseResponse(review.getId());
    }

    @Override
    public void updateReviewStatus(Long reviewId, ReviewStatus reviewStatus) {
        Review review = reviewRepository.findById(reviewId)
            .orElseThrow(() -> new IllegalArgumentException("Review not found"));
        review.setStatus(reviewStatus);
        reviewRepository.save(review);
    }

}
