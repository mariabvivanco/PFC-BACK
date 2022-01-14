package com.example.Proyecto.First.Commit.security.service.uploadfile;

import org.springframework.web.multipart.MultipartFile;

/**
 * Method to upload an image to a cloud hosting service
 */
public interface UploadFile {
    String  uploadImage(MultipartFile photo) throws Exception;
    String  uploadPdf(MultipartFile photo) throws Exception;
}
