package com.example.review.service.impl;

import com.example.review.dto.ProductDTO;
import com.example.review.dto.request.AssignProviderRequest;
import com.example.review.dto.request.CreateProductRequest;
import com.example.review.dto.response.BaseResponse;
import com.example.review.dto.response.ProductWithProviderResponse;
import com.example.review.entity.Product;
import com.example.review.entity.ProductProvider;
import com.example.review.mapper.ProductMapper;
import com.example.review.mapper.ProviderMapper;
import com.example.review.repository.ProductProviderRepository;
import com.example.review.repository.ProductRepository;
import com.example.review.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductProviderRepository productProviderRepository;
    private final ProductMapper productMapper;
    private final ProviderMapper providerMapper;

    @Transactional
    @Override
    public BaseResponse addProduct(CreateProductRequest request) {
        Product product = productRepository.save(productMapper.toEntity(request));
        return new BaseResponse(product.getId());
    }

    @Override
    public List<ProductWithProviderResponse> getAllProducts() {
        List<ProductProvider> all = productProviderRepository.findAll();
        List<ProductDTO> products = new ArrayList<>();
        all.stream().collect(Collectors.groupingBy(ProductProvider::getProduct)).forEach((k , v) -> {
            ProductDTO product = new ProductDTO();
            product.setId(k.getId());
            product.setName(k.getName());
            product.setDescription(k.getDescription());
            product.setProviders(v.stream()
                    .map(ProductProvider::getProvider)
                    .distinct()
                    .map(providerMapper::toDTO)
                    .toList());

        });
        return null;
    }

    @Override
    public ProductWithProviderResponse getProductDetails(Long productId, Long providerId) {
        return null;
    }

    @Override
    public void assignProvidersToExistingProduct(List<AssignProviderRequest> providers) {

    }
}
