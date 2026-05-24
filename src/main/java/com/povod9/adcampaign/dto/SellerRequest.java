package com.povod9.adcampaign.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record SellerRequest(
        @NotBlank String sellerName,
        @NotBlank @Email String email,
        @NotBlank String password,
        @NotNull @Positive BigDecimal emeraldAmountFunds
) {
}
