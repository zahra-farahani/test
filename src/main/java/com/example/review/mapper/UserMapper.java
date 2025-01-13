package com.example.review.mapper;

import com.example.review.dto.UserDTO;
import com.example.review.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User user);

    User toUserEntity(UserDTO userDTO);
}
