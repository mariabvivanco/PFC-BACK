package com.example.Proyecto.First.Commit.service.uploadfile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.Proyecto.First.Commit.controller.StudentController;
import com.example.Proyecto.First.Commit.exception.EmptyImageException;
import com.example.Proyecto.First.Commit.exception.InvalidImageFormatException;
import com.example.Proyecto.First.Commit.exception.InvalidSizeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class UploadFileImpl implements UploadFile{
    private final String cloudName = System.getenv().get("CLOUDINARY_CLOUD_NAME");
    private final String apiKey = System.getenv("CLOUDINARY_API_KEY");
    private final String apiSecret = System.getenv("CLOUDINARY_API_SECRET");

    private final Map params = ObjectUtils.asMap(
            "cloud_name", cloudName,
            "api_key", apiKey,
            "api_secret", apiSecret
    );

    private final Logger log = LoggerFactory.getLogger(StudentController.class);


    Cloudinary cloudinary = new Cloudinary(params);

    /**
     * Upload Image
     *
     * @param photo Image
     * @return String with image url
     */

    @Override
    public  String uploadImage(MultipartFile photo) throws EmptyImageException, InvalidImageFormatException,
            InvalidSizeException, IOException {
        log.warn(photo.getContentType());
        if (photo.isEmpty()) {
            log.error("Empty file");
            throw new EmptyImageException("Empty file");

        }

        if (!Objects.requireNonNull(photo.getContentType()).equalsIgnoreCase("image/png")
                && !photo.getContentType().equalsIgnoreCase("image/jpeg")
                && !photo.getContentType().equalsIgnoreCase("image/jpg")) {

            log.error("Format with error");
            throw new InvalidImageFormatException("Format with error");
        }
        if (photo.getSize()>2097152) {

            log.error("Allowed size exceeded");
            throw new InvalidSizeException("Allowed size exceeded");}

        Map response = cloudinary.uploader().upload((photo.getBytes()),
                ObjectUtils.emptyMap());

        return response.get("secure_url").toString();
    }


    /**
     * Upload Image
     *
     * @param document PDF
     * @return String with image url
     */

    @Override
    public  String uploadPdf(MultipartFile document) throws EmptyImageException, InvalidImageFormatException,
            InvalidSizeException, IOException {
        log.warn(document.getContentType());
        if (document.isEmpty()) {
            log.error("Empty file");
            throw new EmptyImageException("Empty file");

        }

        if (!Objects.requireNonNull(document.getContentType()).equalsIgnoreCase("application/pdf")){
            log.error("Format with error");
            throw new InvalidImageFormatException("Format with error");
        }
        if (document.getSize()>209715200) {

            log.error("Allowed size exceeded");
            throw new InvalidSizeException("Allowed size exceeded");}

        Map response = cloudinary.uploader().upload((document.getBytes()),
                ObjectUtils.emptyMap());

        return response.get("secure_url").toString();
    }
}
