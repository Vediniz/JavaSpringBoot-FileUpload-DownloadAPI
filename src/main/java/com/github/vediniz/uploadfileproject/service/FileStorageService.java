package com.github.vediniz.uploadfileproject.service;

import com.github.vediniz.uploadfileproject.config.FileStorageConfig;
import com.github.vediniz.uploadfileproject.exceptions.FileStorageException;
import com.github.vediniz.uploadfileproject.exceptions.NewFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Logger;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;
    private static final Logger logger = Logger.getLogger(FileStorageService.class.getName());

    @Autowired
    public FileStorageService(FileStorageConfig fileStorageConfig) {
        if (fileStorageConfig.getUploadDir() == null) {
            throw new FileStorageException("Upload directory not configured");
        }
        this.fileStorageLocation = Paths.get(fileStorageConfig.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception e) {
            throw new FileStorageException(
                    "Could not create the directory where the uploaded files will be stored!", e);
        }
    }

    public String storeFile(MultipartFile file) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (filename.contains("..")) {
                throw new FileStorageException(
                        "Sorry! Filename contains invalid path sequence " + filename);
            }
            Path targetLocation = this.fileStorageLocation.resolve(filename);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return filename;
        } catch (Exception e) {
            throw new FileStorageException(
                    "Could not store file " + filename + ". Please try again!", e);
        }
    }

    public Resource loadFileAsResource(String filename) {
        try {
            Path filePath = this.fileStorageLocation.resolve(filename).normalize();
            UrlResource resource = new UrlResource(filePath.toUri());
            if (resource.exists() && resource.isReadable()) {
                return resource;
            } else {
                throw new NewFileNotFoundException ("File not found: " + filename);
            }
        } catch (Exception e) {
            throw new NewFileNotFoundException("File not found: " + filename, e);
        }
    }
}
