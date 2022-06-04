package com.example.crudintermediario.auth;

import com.example.crudintermediario.auth.dto.LoginRequestDTO;
import com.example.crudintermediario.gateways.UserGateway;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.example.crudintermediario.auth.SecurityConstraints.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final UserGateway userGateway;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, UserGateway userGateway) {
        this.authenticationManager = authenticationManager;
        this.userGateway = userGateway;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            final var user = new ObjectMapper().readValue(request.getInputStream(), LoginRequestDTO.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String login = (((User) authResult.getPrincipal()).getUsername());
        com.example.crudintermediario.models.User user = userGateway.findByLogin(login);

        final var authorities = new ArrayList<>();
        for (GrantedAuthority grantedAuthority : authResult.getAuthorities()) {
            final var authority = grantedAuthority.getAuthority();
            authorities.add(authority);
        }

        String token = Jwts.builder()
                .claim("id", user.getId())
                .setSubject(login)
                .claim("authorities", authorities)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        response.addHeader("Access-Control-Expose-Headers", "Authorization");
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }
}
