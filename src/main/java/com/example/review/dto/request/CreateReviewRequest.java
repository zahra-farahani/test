package com.example.review.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReviewRequest {
    @NotNull(message = "'userId' cannot be null")
    private Long userId;

    @NotNull(message = "'productId' cannot be null")
    private Long productId;

    @NotNull(message = "'providerId' cannot be null")
    private Long providerId;

    @Min(value = 0, message = "minimum value for 'rating' is 0")
    @Max(value = 5, message = "maximum value for 'rating' is 5")
    private Integer rating;

    @NotNull(message = "'comment' cannot be null")
    private String comment;
}
