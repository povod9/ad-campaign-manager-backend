package com.povod9.adcampaign.security;

import com.povod9.adcampaign.dto.PrincipalDto;
import com.povod9.adcampaign.exception.InvalidCredentialsException;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityContextService {

    @Bean
    public  PrincipalDto getCurrentPrincipalOrThrow() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getPrincipal() == null) {
            throw new InvalidCredentialsException("You are unauthorized");
        }
        return (PrincipalDto) authentication.getPrincipal();
    }
}
