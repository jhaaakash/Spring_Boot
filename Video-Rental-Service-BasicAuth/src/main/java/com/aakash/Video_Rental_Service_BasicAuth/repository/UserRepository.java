package com.aakash.Video_Rental_Service_BasicAuth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aakash.Video_Rental_Service_BasicAuth.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}