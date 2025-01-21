package com.avionics.wirelessdatatransfer.controller;

import com.avionics.wirelessdatatransfer.service.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/image")
public class StorageController {
    private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(storageService.uploadImage(file));
    }

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFileSystem(@RequestParam MultipartFile file) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(storageService.uploadImageToFileSystem(file));
    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downloadImage(@PathVariable String fileName) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(storageService.downloadImage(fileName));
    }

    @GetMapping("/fileSystem/{fileName}")
    public ResponseEntity<?> downloadImageToFileSystem(@PathVariable String fileName) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(storageService.downloadImageToFileSystem(fileName));
    }
}
