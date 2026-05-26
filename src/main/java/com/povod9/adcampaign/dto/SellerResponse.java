package com.povod9.adcampaign.dto;

import java.math.BigDecimal;

public record SellerResponse(
    Long sellerId, String sellerName, String email, BigDecimal emeraldAmountFunds) {}
