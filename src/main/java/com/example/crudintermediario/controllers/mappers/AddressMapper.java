package com.example.crudintermediario.controllers.mappers;

import com.example.crudintermediario.controllers.dtos.requests.AddressRequestDTO;
import com.example.crudintermediario.controllers.dtos.responses.AddressResponseDTO;
import com.example.crudintermediario.gateways.UserGateway;
import com.example.crudintermediario.models.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { UserGateway.class })
public interface AddressMapper {

    @Mapping(source = "userId", target = "user")
    Address toModel(AddressRequestDTO addressRequestDTO);

    AddressResponseDTO fromModel(Address address);

    List<AddressResponseDTO> fromModelList(List<Address> addressList);

}
