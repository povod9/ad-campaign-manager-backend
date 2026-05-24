package com.povod9.adcampaign.service;


import com.povod9.adcampaign.dto.CampaignRequest;
import com.povod9.adcampaign.dto.CampaignResponse;
import com.povod9.adcampaign.dto.CampaignUpdateRequest;

import java.util.List;

public interface CampaignService {
    CampaignResponse campaignById(Long id);

    List<CampaignResponse> allCampaigns();

    CampaignResponse createCampaign(CampaignRequest campaignRequest);

    void deleteById(Long id);

    CampaignResponse updateById(Long id, CampaignUpdateRequest campaignUpdateRequest);
}
