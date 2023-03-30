package org.example.customers.rest;

import lombok.RequiredArgsConstructor;
import org.example.customers.model.entity.SystemUser;
import org.example.customers.rest.exception.RegisteredUserException;
import org.example.customers.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid SystemUser user) {
        try {
            userService.save(user);
        } catch (RegisteredUserException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
