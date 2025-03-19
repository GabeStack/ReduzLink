package gabe.reduzLink.api.controller.user;

import gabe.reduzLink.api.dtos.user.*;
import gabe.reduzLink.api.entities.user.*;
import gabe.reduzLink.api.repositories.user.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")

public class UserController {
    @Autowired
    private UserRepository repository;
    @PostMapping
    @Transactional
    public void store(@Valid @RequestBody CreateUserDto json){
        repository.save(new User(json));
    }
}

