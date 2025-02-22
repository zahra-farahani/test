package com.example.review.mapper;

import com.example.review.dto.ProviderDTO;
import com.example.review.dto.request.CreateProviderRequest;
import com.example.review.entity.ProductProvider;
import com.example.review.entity.Provider;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProviderMapper {
    ProviderDTO toDTO(Provider provider);
    Provider toEntity(ProviderDTO providerDTO);
    Provider toEntity(CreateProviderRequest providerRequest);

    @Mapping(source = "provider.name", target = "name")
    @Mapping(source = "provider.id", target = "id")
    ProviderDTO toDTO(ProductProvider productProvider);
}
