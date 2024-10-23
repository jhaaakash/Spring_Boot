package com.aakash.Video_Rental_Service_BasicAuth.controller.exchange.request;

import com.aakash.Video_Rental_Service_BasicAuth.model.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
    
}
