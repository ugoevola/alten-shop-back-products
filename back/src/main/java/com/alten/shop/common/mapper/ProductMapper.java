package com.alten.shop.common.mapper;

import com.alten.shop.common.dto.PatchProductDto;
import com.alten.shop.common.dto.PostProductDto;
import com.alten.shop.common.dto.ProductDto;
import com.alten.shop.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product entityFromPostDto(PostProductDto postProductDto);

    Product entityFromPatchDto(@MappingTarget Product product, PatchProductDto patchProductDto);

    ProductDto dtoFromEntity(Product product);
}
