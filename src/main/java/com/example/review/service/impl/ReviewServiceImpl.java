package com.example.review.service.impl;

import com.example.review.dto.request.CreateReviewRequest;
import com.example.review.dto.response.BaseResponse;
import com.example.review.entity.Product;
import com.example.review.entity.Provider;
import com.example.review.entity.Review;
import com.example.review.entity.User;
import com.example.review.enumeration.ReviewStatus;
import com.example.review.repository.ProductRepository;
import com.example.review.repository.ProviderRepository;
import com.example.review.repository.ReviewRepository;
import com.example.review.repository.UserRepository;
import com.example.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final ProviderRepository providerRepository;
    private final UserRepository userRepository;

    @Override
    public BaseResponse addReview(CreateReviewRequest request) {
        Product product = productRepository.findById(request.getProductId())
            .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        Provider provider = providerRepository.findById(request.getProviderId())
            .orElseThrow(() -> new IllegalArgumentException("Provider not found"));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));


        Review review = new Review();
        review.setProduct(product);
        review.setProvider(provider);
        review.setUser(user);
        review.setComment(request.getComment());
        review.setRating(request.getRating());
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
