package com.alten.shop.service;

import com.alten.shop.common.dto.PatchProductDto;
import com.alten.shop.common.dto.PostProductDto;
import com.alten.shop.common.dto.ProductDto;
import com.alten.shop.common.exception.ProductNotFoundException;
import com.alten.shop.common.mapper.ProductMapper;
import com.alten.shop.domain.entity.Product;
import com.alten.shop.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDto createProduct(PostProductDto postProductDto) {
        Product product = this.productRepository.save(ProductMapper.INSTANCE.entityFromPostDto(postProductDto));
        return ProductMapper.INSTANCE.dtoFromEntity(product);
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = this.productRepository.findAll();
        return products.stream().map(ProductMapper.INSTANCE::dtoFromEntity).toList();
    }

    public ProductDto getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = this.productRepository.findById(id);
        Product product = productOptional.orElseThrow(ProductNotFoundException::new);
        return ProductMapper.INSTANCE.dtoFromEntity(product);
    }

    public ProductDto patchProductById(
            Long id,
            PatchProductDto patchProductDto
    ) throws ProductNotFoundException {
        Optional<Product> productOptional = this.productRepository.findById(id);
        Product product = productOptional.orElseThrow(ProductNotFoundException::new);
        product = ProductMapper.INSTANCE.entityFromPatchDto(product, patchProductDto);
        this.productRepository.save(product);
        return ProductMapper.INSTANCE.dtoFromEntity(product);
    }

    public void deleteById(Long id) throws ProductNotFoundException {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException();
        }
        this.productRepository.deleteById(id);
    }


}
