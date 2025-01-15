package com.example.review.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    @NotNull(message = "'name' cannot be null")
    private String name;
    @NotNull(message = "'email' cannot be null")
    private String email;
}
