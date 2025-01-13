package com.example.review.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProviderDTO {
    private Long id;
    private String name;
    private Double price;
    private Boolean isCommentEnabled;
    private Boolean isRatingEnabled;
}
