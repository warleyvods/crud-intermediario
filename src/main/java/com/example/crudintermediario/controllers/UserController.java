package com.example.crudintermediario.controllers;

import com.example.crudintermediario.controllers.dtos.requests.UserRequestDTO;
import com.example.crudintermediario.controllers.dtos.responses.UserResponseDTO;
import com.example.crudintermediario.controllers.mappers.UserMapper;
import com.example.crudintermediario.gateways.UserGateway;
import com.example.crudintermediario.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/user")
public class UserController {

    private final UserGateway userGateway;
    private final UserMapper userMapper;

    public UserController(UserGateway userGateway, UserMapper userMapper) {
        this.userGateway = userGateway;
        this.userMapper = userMapper;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserResponseDTO save(@RequestBody UserRequestDTO userRequestDTO) {
        User user = userMapper.toDomain(userRequestDTO);
        return userMapper.fromDomain(userGateway.save(user));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<UserResponseDTO> listAll() {
        return userMapper.fromDomainList(userGateway.listAll());
    }

}
