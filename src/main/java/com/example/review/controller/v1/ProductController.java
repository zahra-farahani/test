package com.example.review.controller.v1;

import com.example.review.dto.request.CreateProductRequest;
import com.example.review.dto.response.BaseResponse;
import com.example.review.dto.response.ProductWithProviderResponse;
import com.example.review.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<BaseResponse> createProduct(@Valid @RequestBody CreateProductRequest request) {
        return new ResponseEntity<>(productService.addProduct(request), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductWithProviderResponse>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{productId}/{providerId}")
    public ResponseEntity<ProductWithProviderResponse> getProductDetails(@PathVariable Long productId, @PathVariable Long providerId) {
        return new ResponseEntity<>(productService.getProductDetails(productId, providerId), HttpStatus.OK);
    }
}
