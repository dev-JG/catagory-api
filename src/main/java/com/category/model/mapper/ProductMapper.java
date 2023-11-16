package com.category.model.mapper;

import com.category.model.dto.request.ProductAddRequest;
import com.category.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    @Mapping(target = "status", expression = "java(com.category.model.enums.DisplayStatus.NEW)")
    @Mapping(target = "createdDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "modifiedDate", expression = "java(java.time.LocalDateTime.now())")
    Product toNewEntity (ProductAddRequest source);
}
