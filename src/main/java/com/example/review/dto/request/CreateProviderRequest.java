package com.example.review.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProviderRequest {
    @NotNull
    private String name;
}
