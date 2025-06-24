package com.dgsw.jjabflix.controller;

import com.dgsw.jjabflix.dto.UploadRequest;
import com.dgsw.jjabflix.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService service;

    @PostMapping("/upload")
    public String upload(@RequestBody UploadRequest request) {
        return service.uploadPost(request);
    }
}
