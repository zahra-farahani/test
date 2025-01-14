package com.example.review.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "providers")
public class Provider extends BaseEntity<Long> {
    public Provider(Long id) {
        super(id);
    }

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductProvider> productProviders;
}
