package com.example.review.controller.v1;

import com.example.review.dto.ProductDTO;
import com.example.review.dto.request.AssignMultipleProvidersRequest;
import com.example.review.dto.request.CreateProductRequest;
import com.example.review.dto.response.BaseResponse;
import com.example.review.service.ProductProviderService;
import com.example.review.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductProviderService productProviderService;

    @PostMapping
    public ResponseEntity<BaseResponse> createProduct(@Valid @RequestBody CreateProductRequest request) {
        return new ResponseEntity<>(productService.addProduct(request), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(@PageableDefault Pageable pageable) {
        return new ResponseEntity<>(productService.getAllProducts(pageable), HttpStatus.OK);
    }

    @PatchMapping("/{productId}/assignProvider")
    public ResponseEntity<Void> assignProvidersToProduct(@PathVariable Long productId, @Valid @RequestBody AssignMultipleProvidersRequest request) {
        productProviderService.assignProvidersToExistingProduct(productId, request.getProviders());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
