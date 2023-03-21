package org.example.customers.rest;

import lombok.RequiredArgsConstructor;
import org.example.customers.model.entity.SystemUser;
import org.example.customers.model.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid SystemUser user) {
        userRepository.save(user);
    }
}
