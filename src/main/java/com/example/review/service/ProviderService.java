package com.example.review.service;

import com.example.review.dto.request.CreateProviderRequest;
import com.example.review.dto.response.BaseResponse;

public interface ProviderService {
    BaseResponse addProvider(CreateProviderRequest request);
}
