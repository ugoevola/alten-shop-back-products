package com.alten.shop.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")
    private Long id;
    private String code;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String inventoryStatus;
    private String category;
    private String image;
    private Integer rating;
}
