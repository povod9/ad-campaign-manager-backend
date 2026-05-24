package com.povod9.adcampaign.repository;

import com.povod9.adcampaign.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Long> {

    boolean existsByEmail(String email);
    Optional<SellerEntity> findByEmail(String email);

}
