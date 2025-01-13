package com.example.review.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "providers")
public class Provider extends BaseEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;
}
