package gabe.reduzLink.api.entities.user;

import gabe.reduzLink.api.dtos.user.*;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;


@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    private String name;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "O e-mail não pode estar em branco")
    private String email;

    @NotBlank(message = "A senha não pode estar em branco")
    private String password;

    private Boolean status;

    public User( CreateUserDto dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.password = dto.password();
    }

    public void updateUser(@Valid UpdateUserDto json) {
        if (json.name() != null) {
            this.name = json.name();
        }
        if (json.email() != null) {
            this.email = json.email();
        }
        if (json.password() != null) {
            this.password = json.password();
        }
    }
}