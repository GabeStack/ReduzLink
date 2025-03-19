package gabe.reduzLink.api.entities.user;

import gabe.reduzLink.api.dtos.user.CreateUserDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;



@Table(name = "users")
@Entity(name = "user")
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

    public User(CreateUserDto dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.password = dto.password();
    }

}