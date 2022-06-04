package com.example.crudintermediario.controllers;

import com.example.crudintermediario.controllers.dtos.requests.AddressRequestDTO;
import com.example.crudintermediario.controllers.dtos.responses.AddressResponseDTO;
import com.example.crudintermediario.controllers.mappers.AddressMapper;
import com.example.crudintermediario.gateways.AddressGateway;
import com.example.crudintermediario.models.Address;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/address")
public class AddressController {

    private final AddressGateway addressGateway;
    private final AddressMapper addressMapper;

    public AddressController(AddressGateway addressGateway, AddressMapper addressMapper) {
        this.addressGateway = addressGateway;
        this.addressMapper = addressMapper;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AddressResponseDTO save(@RequestBody AddressRequestDTO addressRequestDTO) {
        Address address = addressMapper.toModel(addressRequestDTO);
        return addressMapper.fromModel(addressGateway.save(address));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<AddressResponseDTO> listAll() {
        return addressMapper.fromModelList(addressGateway.listAll());
    }

}
