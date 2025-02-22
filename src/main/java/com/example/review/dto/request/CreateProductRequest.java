package com.example.review.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateProductRequest {
    @NotNull(message = "'name' cannot be null")
    private String name;
    private String description;
    private List<ProductProviderRequest> providers;
}
