package com.gabriel.marketplace.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public final class ExternalProductDTO {

    private ExternalProductDTO() {}

    public record CreateExternalProductRequest(

            @NotBlank(message = "O provedor é obrigatório")
            @Size(max = 80)
            String provider,

            @NotBlank(message = "O id do produto externo é obrigatório")
            @Size(max = 120)
            String externalProductId,

            @NotBlank(message = "O título é obrigatório")
            @Size(max = 200)
            String title,

            @NotBlank(message = "A descrição é obrigatória")
            String description,

            @NotBlank(message = "A URL da imagem é obrigatória")
            @URL(message = "A URL da imagem deve ser válida")
            String imageUrl,

            @NotNull(message = "O preço é obrigatório")
            @Positive(message = "O preço deve ser maior que zero")
            @Digits(
                    integer = 10,
                    fraction = 2,
                    message = "O preço deve ter no máximo 10 dígitos inteiros e 2 casas decimais"
            )
            BigDecimal sourcePrice

    ) {}

    public record CreateExternalProductResponse(
            UUID id,
            String provider,
            String title,
            String category,
            String description,
            String imageUrl,
            BigDecimal sourcePrice
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record DummyJsonProductsResponse(
            List<DummyJsonProductResponse> products,
            Integer total,
            Integer skip,
            Integer limit
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record DummyJsonProductResponse(
            Long id,
            String title,
            String description,
            String category,
            BigDecimal price,
            String thumbnail
    ) {}
}