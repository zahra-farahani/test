package com.example.review.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private List<ProviderDTO> providers;
    private List<ReviewDTO> reviews;
    private Float avgRating;
}
