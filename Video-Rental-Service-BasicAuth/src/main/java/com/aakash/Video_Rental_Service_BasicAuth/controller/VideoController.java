package com.aakash.Video_Rental_Service_BasicAuth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aakash.Video_Rental_Service_BasicAuth.model.Video;
import com.aakash.Video_Rental_Service_BasicAuth.repository.VideoRepository;

@RestController
@RequestMapping("/api")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping("/videos")
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @PostMapping("/admin/videos")
    public ResponseEntity<?> createVideo(@RequestBody Video video) {
        videoRepository.save(video);
        return new ResponseEntity<>("Video created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/admin/videos/{id}")
    public ResponseEntity<?> updateVideo(@PathVariable Long id, @RequestBody Video video) {
        if (!videoRepository.existsById(id)) {
            return new ResponseEntity<>("Video not found", HttpStatus.NOT_FOUND);
        }
        video.setId(id);
        videoRepository.save(video);
        return new ResponseEntity<>("Video updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/admin/videos/{id}")
    public ResponseEntity<?> deleteVideo(@PathVariable Long id) {
        if (!videoRepository.existsById(id)) {
            return new ResponseEntity<>("Video not found", HttpStatus.NOT_FOUND);
        }
        videoRepository.deleteById(id);
        return new ResponseEntity<>("Video deleted successfully", HttpStatus.OK);
    }
}

