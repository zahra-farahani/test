package com.example.review.mapper;

import com.example.review.dto.ReviewDTO;
import com.example.review.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.control.DeepClone;

@Mapper(componentModel = "spring", mappingControl = DeepClone.class, uses = {ProductMapper.class, ProviderMapper.class, UserMapper.class})
public interface ReviewMapper {
    ReviewDTO toReviewDTO(Review review);

    Review toReviewEntity(ReviewDTO reviewDTO);
}
