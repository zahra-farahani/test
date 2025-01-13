package com.example.review.mapper;

import com.example.review.dto.ProviderDTO;
import com.example.review.dto.request.CreateProviderRequest;
import com.example.review.entity.Provider;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProviderMapper {
    ProviderDTO toProviderDTO(Provider provider);

    Provider toProviderEntity(ProviderDTO providerDTO);
    Provider toProviderEntity(CreateProviderRequest providerRequest);
}
