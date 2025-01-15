package com.example.review.mapper;

import com.example.review.dto.ReviewDTO;
import com.example.review.dto.request.CreateReviewRequest;
import com.example.review.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.control.DeepClone;

@Mapper(componentModel = "spring", mappingControl = DeepClone.class, uses = {ProductMapper.class, ProviderMapper.class, UserMapper.class})
public interface ReviewMapper {
    @Mapping(target = "userName", source = "user.name")
    ReviewDTO toReviewDTO(Review review);

    Review toReviewEntity(CreateReviewRequest request);
}
