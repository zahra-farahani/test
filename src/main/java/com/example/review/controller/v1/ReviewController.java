package com.example.review.controller.v1;

import com.example.review.dto.request.CreateReviewRequest;
import com.example.review.dto.request.UpdateReviewStatusRequest;
import com.example.review.dto.response.BaseResponse;
import com.example.review.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<BaseResponse> createReview(@Valid @RequestBody CreateReviewRequest request) {
        return new ResponseEntity<>(reviewService.addReview(request), HttpStatus.OK);
    }

    @PatchMapping("/{reviewId}")
    public ResponseEntity<Void> updateReviewStatus(@PathVariable Long reviewId,
                                                   @Valid @RequestBody UpdateReviewStatusRequest request) {
        reviewService.updateReviewStatus(reviewId, request.getStatus());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
