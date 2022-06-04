package com.example.crudintermediario.controllers.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequestDTO {

    private Long userId;
    private String street;
    private String complement;
    private String number;
    private String zipCode;
    private String district;
    private String city;
    private String state;
    private String country;

}
