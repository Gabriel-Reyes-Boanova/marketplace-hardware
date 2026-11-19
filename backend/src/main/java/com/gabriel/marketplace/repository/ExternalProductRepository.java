package com.gabriel.marketplace.repository;

import com.gabriel.marketplace.entity.Category;
import com.gabriel.marketplace.entity.ExternalProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExternalProductRepository extends JpaRepository<ExternalProduct, UUID> {

    List<ExternalProduct> findByCategory(String categoryName);
}

