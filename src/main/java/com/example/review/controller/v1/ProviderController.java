package com.example.review.controller.v1;

import com.example.review.dto.request.CreateProviderRequest;
import com.example.review.dto.response.BaseResponse;
import com.example.review.service.ProviderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/providers")
@RequiredArgsConstructor
public class ProviderController {
    private final ProviderService providerService;

    @PostMapping
    public ResponseEntity<BaseResponse> createProvider(@Valid @RequestBody CreateProviderRequest request) {
        return new ResponseEntity<>(providerService.addProvider(request), HttpStatus.OK);
    }
}
