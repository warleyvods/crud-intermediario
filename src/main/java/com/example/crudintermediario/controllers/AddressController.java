package com.example.crudintermediario.controllers;

import com.example.crudintermediario.gateways.AddressGateway;
import com.example.crudintermediario.models.Address;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/address")
public class AddressController {

    private final AddressGateway addressGateway;

    public AddressController(AddressGateway addressGateway) {
        this.addressGateway = addressGateway;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Address save(@RequestBody Address address) {
        return addressGateway.save(address);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Address> listAll() {
        return addressGateway.listAll();
    }

}
