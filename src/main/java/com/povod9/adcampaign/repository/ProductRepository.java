package com.povod9.adcampaign.repository;

import com.povod9.adcampaign.entity.ProductEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

  List<ProductEntity> findBySeller_SellerId(Long sellerId);
}
