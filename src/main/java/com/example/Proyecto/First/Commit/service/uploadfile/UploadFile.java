package com.example.Proyecto.First.Commit.service.uploadfile;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFile {
    String  uploadImage(MultipartFile photo) throws Exception;
    String  uploadPdf(MultipartFile document) throws Exception;
}
