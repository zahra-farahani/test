package com.example.review.dto;

import com.example.review.enumeration.ReviewVisibility;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ProviderDTO {
    private Long id;
    private String name;
    private Double price;
    private Boolean isCommentEnabled;
    private Boolean isRatingEnabled;
    private ReviewVisibility reviewVisibility;
}
