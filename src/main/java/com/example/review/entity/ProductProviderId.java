package com.example.review.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
public class ProductProviderId implements Serializable {

    private Long product;
    private Long provider;

    public ProductProviderId() {}

    public ProductProviderId(Long product, Long provider) {
        this.product = product;
        this.provider = provider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductProviderId that = (ProductProviderId) o;
        return Objects.equals(product, that.product) && Objects.equals(provider, that.provider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, provider);
    }
}
