package com.example.review.exception;


public class ProviderNotFoundException extends RuntimeException{
    public ProviderNotFoundException() {
        super("Provider not found");
    }
}
