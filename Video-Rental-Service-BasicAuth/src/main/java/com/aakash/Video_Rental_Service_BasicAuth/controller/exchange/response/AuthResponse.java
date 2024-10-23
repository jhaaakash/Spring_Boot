package com.aakash.Video_Rental_Service_BasicAuth.controller.exchange.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class AuthResponse {
  private final String message = "Success";
}
