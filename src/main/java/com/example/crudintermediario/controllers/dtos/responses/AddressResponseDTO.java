package com.example.crudintermediario.controllers.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponseDTO {

    private String street;
    private String complement;
    private String number;
    private String zipCode;
    private String district;
    private String city;
    private String state;
    private String country;

}
