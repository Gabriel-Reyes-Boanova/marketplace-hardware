package com.gabriel.marketplace.repository;

import com.gabriel.marketplace.entity.StoreProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StoreProductRepository extends JpaRepository<StoreProduct, UUID> {
    StoreProduct findByCategory(String categoryTitle);

    StoreProduct findbyTitle(String title);

    boolean existsByCategory(String categoryTitle);
    boolean existsByTitle(String title);
}
