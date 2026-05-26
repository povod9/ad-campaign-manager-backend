package com.povod9.adcampaign.mapper;

import com.povod9.adcampaign.dto.ProductResponse;
import com.povod9.adcampaign.entity.ProductEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  ProductResponse entityToResponse(ProductEntity productEntity);

  List<ProductResponse> listEntitiesToResponse(List<ProductEntity> productEntities);
}
