package com.web.MyPetForApp.image.controller;

import com.web.MyPetForApp.image.mapper.ImageMapper;
import com.web.MyPetForApp.image.service.ImageService;
import com.web.MyPetForApp.image.util.ImageUtils;
import com.web.MyPetForApp.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/s3")
public class ImageController {
    private final ImageService imageService;
    private final MemberService memberService;
    private final ImageUtils imageUtils;
    private final ImageMapper imageMapper;
    private final Logger logger = LoggerFactory.getLogger(ImageController.class);

    @PostMapping("/file/member")
    public ResponseEntity uploadFile(@RequestPart List<MultipartFile> multipartFiles, @RequestParam Long memberId) {
//        Long memberId = memberService.searchMemberIdByEmail(authentication.getName());
        logger.info("upload memberId : {}", memberId);
        List<String> fileNameList = imageService.uploadFile(memberId, multipartFiles);
        return new ResponseEntity<>(imageMapper.ImageListToImageDto(fileNameList) , HttpStatus.OK);
    }

    @DeleteMapping("/file/member")
    public ResponseEntity removeFile(@RequestParam String fileName) {
        imageService.deleteFile(fileName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/file/member")
    public ResponseEntity downloadFile(@RequestParam String storedFileName) {
        byte[] data = imageService.downloadFile(storedFileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        HttpHeaders headers = imageUtils.buildHeaders(storedFileName, data);

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}
