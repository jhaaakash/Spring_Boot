package com.aakash.Video_Rental_Service_BasicAuth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aakash.Video_Rental_Service_BasicAuth.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    Optional findById(Long id);
}
