package com.povod9.adcampaign.mapper;

import com.povod9.adcampaign.dto.CampaignResponse;
import com.povod9.adcampaign.dto.CampaignUpdateRequest;
import com.povod9.adcampaign.entity.CampaignEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CampaignMapper {

  @Mapping(source = "product.productId", target = "productId")
  @Mapping(source = "product.seller.emeraldAmountFunds", target = "sellerBalance")
  CampaignResponse entityToResponse(CampaignEntity campaignEntity);

  List<CampaignResponse> listEntityToResponse(List<CampaignEntity> campaignEntities);

  @Mapping(target = "campaignFund", ignore = true)
  @Mapping(target = "product", ignore = true)
  void updateEntityFromRequest(
      CampaignUpdateRequest campaignUpdateRequest, @MappingTarget CampaignEntity campaignEntity);
}
