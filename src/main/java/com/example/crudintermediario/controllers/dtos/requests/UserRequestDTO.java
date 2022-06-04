package com.example.crudintermediario.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {

    private String name;
    private String cpf;
    private Integer age;
    private String login;

}
