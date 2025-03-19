package gabe.reduzLink.api.dtos.user;

import jakarta.validation.constraints.*;

public record CreateUserDto(
        @NotBlank(message = "O nome não pode estar em branco")
        String name,

        @Email(message = "E-mail inválido")
        @NotBlank(message = "O e-mail não pode estar em branco")
        String email,

        @NotBlank(message = "A senha não pode estar em branco")
        String password
) {}
