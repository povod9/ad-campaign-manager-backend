package com.povod9.adcampaign.service;

import com.povod9.adcampaign.dto.*;

public interface SellerService {
  SellerResponse createSellerAccount(SellerRequest seller);

  LoginResponse loginSeller(LoginRequest login);

  SellerResponse updateSeller(SellerUpdateRequest sellerUpdateRequest);
}
