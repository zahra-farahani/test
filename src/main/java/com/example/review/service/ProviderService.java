package com.example.review.service;

import com.example.review.dto.request.CreateProviderRequest;
import com.example.review.dto.response.BaseResponse;
import com.example.review.entity.Provider;

public interface ProviderService {
    BaseResponse addProvider(CreateProviderRequest request);
    Provider fetchProvider(Long id);
}
