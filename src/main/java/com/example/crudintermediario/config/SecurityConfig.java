package com.example.crudintermediario.config;

import com.example.crudintermediario.auth.JWTAuthenticationFilter;
import com.example.crudintermediario.auth.JWTAuthorizationFilter;
import com.example.crudintermediario.auth.service.CustomUserDetailsService;
import com.example.crudintermediario.gateways.UserGateway;
import com.example.crudintermediario.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.example.crudintermediario.auth.SecurityConstraints.LOGIN;

@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService customUserDetailsService;
    private final UserGateway userGateway;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().headers().frameOptions().disable().and().csrf().disable()
                .authorizeRequests().antMatchers(HttpMethod.GET, LOGIN).permitAll()
                .antMatchers("/*/address/**").permitAll()
                .antMatchers("/*/user/**").hasRole("ADMIN")
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager(), userGateway))
                .addFilter(new JWTAuthorizationFilter(authenticationManager(), customUserDetailsService));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
