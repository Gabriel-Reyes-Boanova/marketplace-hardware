package com.gabriel.marketplace.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "category")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Setter
    @NotBlank(message = "A categoria deve ter um título")
    @Column(nullable = false, length = 120)
    private String title;

    @Setter
    @NotBlank(message = "A categoria deve ter uma descrição")
    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "category")
    private List<ExternalProduct> externalProducts;
}
