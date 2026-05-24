package com.povod9.adcampaign.controller;

import com.povod9.adcampaign.dto.*;
import com.povod9.adcampaign.service.SellerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sellers")
public class SellerController {

    private final SellerService service;

    @PostMapping("/registration")
    public ResponseEntity<SellerResponse> registerSellerAccount(@RequestBody @Valid SellerRequest seller){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createSellerAccount(seller));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginSeller(@RequestBody @Valid LoginRequest login){
        return ResponseEntity.ok(service.loginSeller(login));
    }

    @PutMapping
    public ResponseEntity<SellerResponse> updateSeller(@RequestBody SellerUpdateRequest sellerUpdateRequest){
        return ResponseEntity.ok(service.updateSeller(sellerUpdateRequest));
    }
}
