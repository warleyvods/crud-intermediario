package com.example.crudintermediario.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Address {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String complement;
    private String number;
    private String zipCode;
    private String district;
    private String city;
    private String state;
    private String country;

    @JsonIgnore
    @NotNull
    @ManyToOne
    private User user;

}
