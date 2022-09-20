package com.web.MyPetForApp.image.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import com.web.MyPetForApp.exception.error.FileCountExceedException;
import com.web.MyPetForApp.image.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageService {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    private final AmazonS3 amazonS3;
    private final ImageUtils imageUtils;


    public List<String> uploadFile(Long memberId, List<MultipartFile> multipartFiles) {
        List<String> fileNameList = new ArrayList<>();

        multipartFiles.forEach(file -> {
            if(fileNameList.size() > 10) {
//                throw new FileCountExceedException("업로드 가능 개수는 10개 이하입니다.");
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "업로드 가능 파일 개수는 10개 이하입니다.");
            }

            String fileName = imageUtils.createFileName(memberId, file.getOriginalFilename());
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            objectMetadata.setContentLength(file.getSize());

            try (InputStream inputStream = file.getInputStream()) {
                amazonS3.putObject(new PutObjectRequest(bucket, fileName, inputStream, objectMetadata)
                        .withCannedAcl(CannedAccessControlList.PublicRead));
                fileNameList.add(fileName);
            } catch (IOException e) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패했습니다.");
            }
        });
        return fileNameList;
    }

    public byte[] downloadFile(String resourcePath) {
        validateFileExists(resourcePath);

        S3Object s3Object = amazonS3.getObject(bucket, resourcePath);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();

        try {
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "파일 다운로드에 실패했습니다.");
        }
    }

    public void deleteFile(String fileName) {
        amazonS3.deleteObject(new DeleteObjectRequest(bucket, fileName));
    }

    private void validateFileExists(String resourcePath) {
        if (!amazonS3.doesObjectExist(bucket, resourcePath)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "파일이 존재하지 않습니다.");
        }
    }
}
