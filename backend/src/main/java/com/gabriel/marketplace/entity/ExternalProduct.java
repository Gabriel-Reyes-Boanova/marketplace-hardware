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


@Entity
@Table(
        name = "external_product",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_provider_external_product",
                        columnNames = {"provider", "external_product_id"}
                )
        }
)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExternalProduct extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 80)
    private String provider;

    @Column(nullable = false, length = 120, name = "external_product_id")
    private String externalProductId;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT", name = "image_url")
    private String imageUrl;

    @Column(precision = 12, scale = 2, name = "source_price")
    private BigDecimal sourcePrice;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "category_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_external_product_category")
    )
    private Category category;

    @Column(name = "last_synced_at")
    private OffsetDateTime lastSyncedAt;

    public void setLastSyncedAt() {
        this.lastSyncedAt = OffsetDateTime.now();
    }

    public void setSourcePrice(BigDecimal price) {
        if (price != null && price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Preço inválido.");
        }
        this.sourcePrice = price;
    }
}
