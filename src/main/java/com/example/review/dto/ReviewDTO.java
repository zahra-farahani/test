package com.example.review.dto;

import com.example.review.enumeration.ReviewStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewDTO {
    private Long id;
    private ProductDTO product;
    private ProviderDTO provider;
    private UserDTO user;
    private String comment;
    private Integer rating;
    private ReviewStatus status;
}
