package com.example.crudintermediario.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDTO {

    private String name;
    private String cpf;
    private Integer age;
    private List<AddressResponseDTO> address;

}
