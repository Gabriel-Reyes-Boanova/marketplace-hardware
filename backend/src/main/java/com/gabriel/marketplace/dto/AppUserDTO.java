package com.gabriel.marketplace.dto;

import com.gabriel.marketplace.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;


public final class AppUserDTO {


    private AppUserDTO() {}


    public record CreateRequest(
            @NotBlank(message = "O nome é obrigatório")
            @Size(max = 120)
            String name,

            @NotBlank(message = "O e-mail é obrigatório")
            @Email(message = "E-mail inválido")
            @Size(max = 180)
            String email,

            @NotBlank(message = "A senha é obrigatória")
            @Size(min = 6, max = 20, message = "A senha deve ter entre 6 e 20 caracteres")
            String password,

            @NotNull(message = "O papel (Role) do usuário é obrigatório")
            Role role
    ) {}


    public record UpdateRequest(
            @NotBlank(message = "O email é obrigatório")
            @Size(max = 120)
            String email
    ) {}


    public record UserResponse(
            UUID id,
            String name,
            String email,
            Role role,
            boolean active
    ) {}
}
