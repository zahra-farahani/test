package com.example.review.dto.request;

import com.example.review.enumeration.ReviewVisibility;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductProviderRequest {
    @NotNull(message = "provider's id cannot be null")
    private Long providerId;
    @NotNull(message = "provider's price cannot be null")
    private Double price;
    @NotNull(message = "provider's isCommentEnabled cannot be null")
    private Boolean isCommentEnabled;
    @NotNull(message = "provider's isRatingEnabled cannot be null")
    private Boolean isRatingEnabled;
    @NotNull(message = "provider's reviewVisibility cannot be null")
    private ReviewVisibility reviewVisibility;
}
