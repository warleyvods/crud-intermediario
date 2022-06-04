package com.example.crudintermediario.auth;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityConstraints {

    public static final String SECRET = "aula";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String LOGIN = "/login";
    public static final Long EXPIRATION_TIME = 3600000L; //1 hora

}
