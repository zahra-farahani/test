package com.example.review.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewStatsDTO {
    private Long totalReviews;
    private Double averageRating;

    public ReviewStatsDTO(Long totalReviews, Double averageRating) {
        this.totalReviews = totalReviews;
        this.averageRating = averageRating;
    }
}
