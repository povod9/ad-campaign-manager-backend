package com.povod9.adcampaign.mapper;

import com.povod9.adcampaign.dto.SellerResponse;
import com.povod9.adcampaign.entity.SellerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SellerMapper {

    SellerResponse entityToResponse(SellerEntity sellerEntity);
}
