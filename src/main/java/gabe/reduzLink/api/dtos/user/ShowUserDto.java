package gabe.reduzLink.api.dtos.user;

import gabe.reduzLink.api.entities.user.*;

public record ShowUserDto(Long id, String name,String email,String password) {

    public ShowUserDto(User user) {
        this(user.getId(), user.getName(), user.getEmail(), user.getPassword() );
    }
}
