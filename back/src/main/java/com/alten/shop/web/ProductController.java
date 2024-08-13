package com.alten.shop.web;

import com.alten.shop.common.dto.PatchProductDto;
import com.alten.shop.common.dto.PostProductDto;
import com.alten.shop.common.dto.ProductDto;
import com.alten.shop.common.exception.ProductNotFoundException;
import com.alten.shop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    ProductDto postProduct(@RequestBody @Valid PostProductDto postProductDto) {
        return productService.createProduct(postProductDto);
    }

    @GetMapping
    List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    ProductDto getProductById(@PathVariable Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @PatchMapping("{id}")
    ProductDto patchProduct(
            @PathVariable Long id,
            @RequestBody PatchProductDto patchProductDto
    ) throws ProductNotFoundException {
        return productService.patchProductById(id, patchProductDto);
    }

    @DeleteMapping("{id}")
    void deleteProduct(@PathVariable Long id) throws ProductNotFoundException {
        productService.deleteById(id);
    }

}
