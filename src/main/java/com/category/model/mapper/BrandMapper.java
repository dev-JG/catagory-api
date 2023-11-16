package com.category.model.mapper;

import com.category.model.dto.request.BrandAddCommand;
import com.category.model.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BrandMapper {

    @Mapping(target = "createdDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "modifiedDate", expression = "java(java.time.LocalDateTime.now())")
    Brand toNewEntity (BrandAddCommand source);
}
