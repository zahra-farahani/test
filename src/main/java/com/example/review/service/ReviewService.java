package com.example.review.service;

import com.example.review.dto.request.CreateReviewRequest;
import com.example.review.dto.response.BaseResponse;
import com.example.review.enumeration.ReviewStatus;


public interface ReviewService {
    BaseResponse addReview(CreateReviewRequest request);
    void updateReviewStatus(Long reviewId, ReviewStatus reviewStatus);
}
