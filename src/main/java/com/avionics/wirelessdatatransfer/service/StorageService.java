package com.avionics.wirelessdatatransfer.service;

import com.avionics.wirelessdatatransfer.entity.FileData;
import com.avionics.wirelessdatatransfer.entity.ImageData;
import com.avionics.wirelessdatatransfer.exception.FileDataNotFoundException;
import com.avionics.wirelessdatatransfer.exception.ImageNotFoundException;
import com.avionics.wirelessdatatransfer.repository.FileDataRepository;
import com.avionics.wirelessdatatransfer.repository.StorageRepository;
import com.avionics.wirelessdatatransfer.util.ImageUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class StorageService {
    private final StorageRepository storageRepository;
    private final FileDataRepository fileDataRepository;

    public StorageService(StorageRepository storageRepository, FileDataRepository fileDataRepository) {
        this.storageRepository = storageRepository;
        this.fileDataRepository = fileDataRepository;
    }

    private final String FOLDER_PATH = "C:\\Users\\DBPURANIK\\Downloads\\MyFiles\\";

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = new ImageData();
        imageData.setName(file.getOriginalFilename());
        imageData.setType(file.getContentType());
        imageData.setImageData(ImageUtils.compressImage(file.getBytes()));
        imageData = storageRepository.save(imageData);

        if(imageData!= null){
            return "File uploaded successfully: "+ file.getOriginalFilename();
        }
        return null;
    }

    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath = FOLDER_PATH+file.getOriginalFilename();
        FileData fileData = new FileData();
        fileData.setName(file.getOriginalFilename());
        fileData.setType(file.getContentType());
        fileData.setFilePath(filePath);
        fileData = fileDataRepository.save(fileData);

        file.transferTo(new File(filePath));

        if(fileData!= null){
            return "File uploaded successfully: "+ filePath;
        }
        return null;
    }

    public byte[] downloadImage(String filename){
        ImageData dbImage = storageRepository.findByName(filename).orElseThrow(()-> new ImageNotFoundException("Image Not Found"));
        return ImageUtils.decompressImage(dbImage.getImageData());
    }

    public byte[] downloadImageToFileSystem(String filename) throws IOException {
        FileData fileData = fileDataRepository.findByName(filename).orElseThrow(()-> new FileDataNotFoundException("File Data Not Found"));
        String filePath = fileData.getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
}
