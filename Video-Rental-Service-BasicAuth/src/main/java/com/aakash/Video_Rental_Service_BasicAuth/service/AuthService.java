package com.aakash.Video_Rental_Service_BasicAuth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aakash.Video_Rental_Service_BasicAuth.controller.exchange.request.AuthRequest;
import com.aakash.Video_Rental_Service_BasicAuth.controller.exchange.request.RegisterRequest;
import com.aakash.Video_Rental_Service_BasicAuth.controller.exchange.response.AuthResponse;
import com.aakash.Video_Rental_Service_BasicAuth.model.User;
import com.aakash.Video_Rental_Service_BasicAuth.model.enums.Role;
import com.aakash.Video_Rental_Service_BasicAuth.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        if (request.getRole() == null) {
            request.setRole(Role.CUSTOMER);
        }

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userRepository.save(user);

        return AuthResponse.builder().build();

    }
    

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword()));
        return AuthResponse.builder().build();
    }
}
