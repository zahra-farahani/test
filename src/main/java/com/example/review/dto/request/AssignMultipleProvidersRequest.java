package com.example.review.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AssignMultipleProvidersRequest {
    @NotNull(message = "'provider' can't be null")
    private List<ProductProviderRequest> providers;
}
