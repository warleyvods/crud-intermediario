package com.example.crudintermediario.gateways;

import com.example.crudintermediario.models.Address;
import com.example.crudintermediario.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressGateway {
    
    private final AddressRepository addressRepository;

    public AddressGateway(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public List<Address> listAll() {
        return addressRepository.findAll();
    }
}
