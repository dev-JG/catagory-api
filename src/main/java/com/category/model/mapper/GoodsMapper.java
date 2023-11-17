package com.category.model.mapper;

import com.category.model.dto.command.GoodsAddCommand;
import com.category.model.entity.Goods;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GoodsMapper {

    @Mapping(target = "status", expression = "java(com.category.model.enums.DisplayStatus.NEW)")
    @Mapping(target = "createdDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "modifiedDate", expression = "java(java.time.LocalDateTime.now())")
    Goods toNewEntity (GoodsAddCommand source);
}
