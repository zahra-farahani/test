package com.example.review.service;

import com.example.review.dto.request.CreateUserRequest;
import com.example.review.dto.response.BaseResponse;
import com.example.review.entity.User;

public interface UserService {
    BaseResponse addUser(CreateUserRequest request);

    User fetchByUserId(Long userId);
}
