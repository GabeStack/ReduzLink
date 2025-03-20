package gabe.reduzLink.api.controller.user;

import gabe.reduzLink.api.dtos.user.*;
import gabe.reduzLink.api.entities.user.*;
import gabe.reduzLink.api.repositories.user.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
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

    @GetMapping
    public Page<ShowUserDto> show(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination) {
    return repository.findAll(pagination).map(ShowUserDto::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdateUserDto json){
        User user = repository.getReferenceById(json.id());
        user.updateUser(json);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void destroy(@PathVariable Long id){
        repository.deleteById(id);
    }
}

