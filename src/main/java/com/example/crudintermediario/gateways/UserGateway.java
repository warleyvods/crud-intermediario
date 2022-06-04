package com.example.crudintermediario.gateways;

import com.example.crudintermediario.models.User;
import com.example.crudintermediario.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public void insertAdminUser() {
        if(userRepository.findByLogin("admin") == null) {
            log.info("Administrator user not found, creating...");
            final var user = new User();
            user.setName("Administrador");
            user.setLogin("admin");
            user.setPassword(new BCryptPasswordEncoder().encode("123"));
            user.setAdmin(true);
            userRepository.save(user);
        }
    }

}
