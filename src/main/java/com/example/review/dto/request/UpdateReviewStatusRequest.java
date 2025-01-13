package com.example.review.dto.request;

import com.example.review.enumeration.ReviewStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateReviewStatusRequest {
    @NotNull
    private ReviewStatus reviewStatus;
}
