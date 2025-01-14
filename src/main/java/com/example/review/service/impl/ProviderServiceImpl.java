package com.example.review.service.impl;

import com.example.review.dto.request.CreateProviderRequest;
import com.example.review.dto.response.BaseResponse;
import com.example.review.entity.Provider;
import com.example.review.exception.ProviderNotFoundException;
import com.example.review.mapper.ProviderMapper;
import com.example.review.repository.ProviderRepository;
import com.example.review.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    @Override
    public BaseResponse addProvider(CreateProviderRequest request) {
        Provider provider = providerRepository.save(providerMapper.toEntity(request));
        return new BaseResponse(provider.getId());
    }

    @Override
    public Provider fetchProvider(Long id) {
        return Optional.of(providerRepository.findById(id)).get().orElseThrow(ProviderNotFoundException::new);
    }


}
