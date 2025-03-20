package gabe.reduzLink.api.dtos.user;

import jakarta.validation.constraints.NotNull;

public record UpdateUserDto(
        @NotNull
        Long id,
        String name,
        String email,
        String password
) {

}
