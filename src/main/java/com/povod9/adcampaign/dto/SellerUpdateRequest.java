package com.povod9.adcampaign.dto;

import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record SellerUpdateRequest(
    String sellerName, String email, String password, @Positive BigDecimal emeraldAmountFunds) {}
