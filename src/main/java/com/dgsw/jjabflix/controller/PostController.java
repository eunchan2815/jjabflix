package com.dgsw.jjabflix.controller;

import lombok.RequiredArgsConstructor;
import com.dgsw.jjabflix.dto.UploadRequest;
import com.dgsw.jjabflix.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService service;

    @PostMapping("/upload")
    public String upload(@RequestBody UploadRequest request) {
        return service.uploadPost(request);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        return service.deletePost(id);
    }
}
