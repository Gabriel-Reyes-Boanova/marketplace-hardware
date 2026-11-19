package com.gabriel.marketplace.dto;

import com.gabriel.marketplace.entity.Category;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.UUID;

public class CategoryDTO {

    private CategoryDTO(){}

    public record CategoryRequest(
            @NotBlank(message = "A categoria deve ter um titulo")
            String title,
            @NotBlank(message = "A categoria deve ter uma descricao")
            @Column(columnDefinition = "TEXT")
            String description
    ){}

    @Builder
    public record CategoryResponse(
            UUID id,
            String title,
            String description,
            OffsetDateTime createdAt
    ){}
}
