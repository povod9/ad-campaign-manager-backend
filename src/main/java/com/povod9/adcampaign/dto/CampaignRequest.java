package com.povod9.adcampaign.dto;

import com.povod9.adcampaign.entity.ProductEntity;
import com.povod9.adcampaign.enums.Status;
import com.povod9.adcampaign.enums.TownName;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.List;

public record CampaignRequest(
        @NotBlank String name,
        @NotEmpty List<String> keywords,
        @NotNull @DecimalMin(value = "10.00", message = "Bid amount must be at least 10.00") BigDecimal bidAmount,
        @NotNull @Positive BigDecimal campaignFund,
        @NotNull Status status,
        @NotNull List<TownName> town,
        @NotNull @Positive Integer radius,
        @NotNull Long productId
) {
}
