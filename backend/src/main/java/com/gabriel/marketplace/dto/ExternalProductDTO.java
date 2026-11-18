package com.gabriel.marketplace.dto;

import com.gabriel.marketplace.entity.Role;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.math.BigDecimal;
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

            @NotBlank(message = "O titulo é obrigatório")
            @Size(max = 200)
            String tittle,

            @NotBlank(message = "A descrição é obrigatória")
            String description,

            @NotBlank(message = "A url da imagem é obrigatória")
            @URL(message = "A url da imagem deve ser um endereço válido")
            String imageUrl,


            @NotNull(message = "O preço é obrigatório")
            @Positive(message = "O preço deve ser maior que zero")
            @Digits(integer = 10, fraction = 2, message = "O preço deve ter no máximo 10 dígitos inteiros e 2 casas decimais")
            BigDecimal sourcePrice
    ) {}


    public record UserResponse(
            UUID id,
            String provider,
            String tittle,
            String description,
            String imageuRL,
            BigDecimal sorcePrice
    ) {}
}
