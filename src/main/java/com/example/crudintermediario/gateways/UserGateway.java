package com.example.crudintermediario.gateways;

import com.example.crudintermediario.models.User;
import com.example.crudintermediario.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGateway {

    private final UserRepository userRepository;

    public UserGateway(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
       return userRepository.save(user);
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public User byId(Long id) {
        return userRepository.findById(id).get();
    }
}
