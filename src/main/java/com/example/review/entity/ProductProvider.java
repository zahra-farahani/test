package com.example.review.entity;

import com.example.review.enumeration.ReviewVisibility;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@IdClass(ProductProviderId.class)
@Table(name = "product_provider")
public class ProductProvider {

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    @Column(name = "is_comment_enabled", nullable = false)
    private Boolean isCommentEnabled;

    @Column(name = "is_rating_enabled", nullable = false)
    private Boolean isRatingEnabled;

    @Enumerated(EnumType.STRING)
    @Column(name = "review_visibility", nullable = false)
    private ReviewVisibility reviewVisibility;

    @Column(name = "price", nullable = false)
    private Double price;
}


