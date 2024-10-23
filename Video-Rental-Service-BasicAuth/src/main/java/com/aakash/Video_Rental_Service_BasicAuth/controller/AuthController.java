package com.aakash.Video_Rental_Service_BasicAuth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.aakash.Video_Rental_Service_BasicAuth.controller.exchange.request.AuthRequest;
import com.aakash.Video_Rental_Service_BasicAuth.controller.exchange.request.RegisterRequest;
import com.aakash.Video_Rental_Service_BasicAuth.controller.exchange.response.AuthResponse;
import com.aakash.Video_Rental_Service_BasicAuth.service.AuthService;



@Controller
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(
            @RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/adminview")
    public ResponseEntity<AuthResponse> adminview(
            @RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    
}