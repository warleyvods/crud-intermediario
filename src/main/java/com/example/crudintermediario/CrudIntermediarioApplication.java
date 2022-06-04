package com.example.crudintermediario;

import com.example.crudintermediario.gateways.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
@SpringBootApplication
public class CrudIntermediarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudIntermediarioApplication.class, args);
    }

    private final UserGateway userGateway;

    @Bean
    InitializingBean sendData() {
        return userGateway::insertAdminUser;
    }
}
