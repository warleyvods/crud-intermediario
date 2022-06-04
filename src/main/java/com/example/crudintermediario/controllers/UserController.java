package com.example.crudintermediario.controllers;

import com.example.crudintermediario.gateways.UserGateway;
import com.example.crudintermediario.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/user")
public class UserController {

    private final UserGateway userGateway;

    public UserController(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User save(@RequestBody User user) {
        return userGateway.save(user);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<User> listAll() {
        return userGateway.listAll();
    }

}
