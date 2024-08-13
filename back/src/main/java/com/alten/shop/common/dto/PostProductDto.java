package com.alten.shop.common.dto;

import lombok.Getter;

@Getter
public class PostProductDto {
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
