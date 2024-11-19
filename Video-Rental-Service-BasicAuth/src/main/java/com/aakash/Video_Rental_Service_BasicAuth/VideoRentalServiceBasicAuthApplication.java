package com.aakash.Video_Rental_Service_BasicAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VideoRentalServiceBasicAuthApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(VideoRentalServiceBasicAuthApplication.class, args);
	}

	@GetMapping("/")
	public String welcome() {
		return "HELLO FROM AUTHENTICATED ENDPOINT!";
	}

	@GetMapping("/customer")
	@PreAuthorize("hasAuthority('CUSTOMER')")
	public String welcomeCustomer() {
		return "HELLO FROM CUSTOMER ENDPOINT!";
	}

	@GetMapping("/admins")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String welcomeAdmin() {
		return "HELLO FROM ADMIN'S ENDPOINT!";
	}
}
