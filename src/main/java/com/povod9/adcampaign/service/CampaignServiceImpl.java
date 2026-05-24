package com.povod9.adcampaign.service;

import com.povod9.adcampaign.dto.*;
import com.povod9.adcampaign.entity.CampaignEntity;
import com.povod9.adcampaign.entity.ProductEntity;
import com.povod9.adcampaign.enums.Status;
import com.povod9.adcampaign.exception.AccessDeniedException;
import com.povod9.adcampaign.mapper.CampaignMapper;
import com.povod9.adcampaign.repository.CampaignRepository;
import com.povod9.adcampaign.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.povod9.adcampaign.helper_method.SecurityUtil.getCurrentPrincipalOrThrow;


@Service
@RequiredArgsConstructor
public class CampaignServiceImpl implements CampaignService{

    private final CampaignRepository campaignRepository;
    private final ProductRepository productRepository;
    private final CampaignMapper mapper;

    @Override
    public CampaignResponse campaignById(Long id) {
        PrincipalDto principalDto = getCurrentPrincipalOrThrow();
        CampaignEntity campaignEntity = getCampaignOrThrow(id);
        checkCampaignOwnerOrThrow(campaignEntity,principalDto);
        return mapper.entityToResponse(campaignEntity);
    }

    @Override
    public List<CampaignResponse> allCampaigns() {
        PrincipalDto principalDto = getCurrentPrincipalOrThrow();
        List<CampaignEntity> campaignEntities = campaignRepository.findByProduct_Seller_SellerId(principalDto.id());
        return mapper.listEntityToResponse(campaignEntities);
    }

    @Override
    public CampaignResponse createCampaign(CampaignRequest campaignRequest) {
        PrincipalDto principalDto = getCurrentPrincipalOrThrow();

        ProductEntity productEntity = productRepository.findById(campaignRequest.productId())
                .orElseThrow(() -> new EntityNotFoundException("Cannot find product by id: " + campaignRequest.productId()));

        if(!productEntity.getSeller().getSellerId().equals(principalDto.id())){
            throw new AccessDeniedException("Forbidden");
        }

        CampaignEntity campaignEntity = new CampaignEntity(
                null,
                campaignRequest.name(),
                campaignRequest.keywords(),
                campaignRequest.bidAmount(),
                campaignRequest.campaignFund(),
                Status.OFF,
                campaignRequest.town(),
                campaignRequest.radius(),
                productEntity
        );

        campaignRepository.save(campaignEntity);

        return mapper.entityToResponse(campaignEntity);
    }

    @Override
    public void deleteById(Long id) {
        PrincipalDto principalDto = getCurrentPrincipalOrThrow();
        CampaignEntity campaignEntity = getCampaignOrThrow(id);
        checkCampaignOwnerOrThrow(campaignEntity, principalDto);
        campaignRepository.delete(campaignEntity);
    }

    @Override
    public CampaignResponse updateById(Long id, CampaignUpdateRequest campaignUpdateRequest) {
        PrincipalDto principalDto = getCurrentPrincipalOrThrow();
        CampaignEntity campaignEntity = getCampaignOrThrow(id);
        checkCampaignOwnerOrThrow(campaignEntity, principalDto);
        mapper.updateEntityFromRequest(campaignUpdateRequest, campaignEntity);
        return mapper.entityToResponse(campaignEntity);
    }

    private void checkCampaignOwnerOrThrow(CampaignEntity campaignEntity, PrincipalDto principalDto){
        if(!campaignEntity.getProduct().getSeller().getSellerId().equals(principalDto.id())){
            throw new AccessDeniedException("Forbidden");
        }
    }
    private CampaignEntity getCampaignOrThrow(Long id){
        return campaignRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find campaign by id: " + id));
    }
}
