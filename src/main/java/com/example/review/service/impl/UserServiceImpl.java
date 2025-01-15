package com.example.review.service.impl;

import com.example.review.dto.request.CreateUserRequest;
import com.example.review.dto.response.BaseResponse;
import com.example.review.entity.User;
import com.example.review.exception.UserNotFoundException;
import com.example.review.mapper.UserMapper;
import com.example.review.repository.UserRepository;
import com.example.review.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public BaseResponse addUser(CreateUserRequest request) {
        return new BaseResponse(userRepository.save(userMapper.toUserEntity(request)).getId());
    }

    @Override
    public User fetchByUserId(Long userId) {
        return Optional.of(userRepository.findById(userId)).get().orElseThrow(UserNotFoundException::new);
    }
}
