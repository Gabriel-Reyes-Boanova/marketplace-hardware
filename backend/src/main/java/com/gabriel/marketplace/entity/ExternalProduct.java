package com.gabriel.marketplace.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "external_product")
public class ExternalProduct extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false,length = 80)
    private String provider;

    @Column(nullable = false,length = 120,name = "external_product_id")
    private String externalProductId;

    @Column(nullable = false,length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT", name = "image_url")
    private String imageUrl;

    @Column(scale = 2,nullable = false,name = "source_price",precision = 12)
    private BigDecimal sourcePrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category", nullable = false,
            foreignKey = @ForeignKey(name = "fk_external_product_category"))
    private Category category;

    @Column(name = "last_synced_at")
    private OffsetDateTime lastSyncedAt;

    public void setLastSyncedAt(){
        lastSyncedAt = OffsetDateTime.now();
    }

    public void setSourcePrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor do preço deve ser maior que zero.");
        }
        this.sourcePrice = price;
    }
}
