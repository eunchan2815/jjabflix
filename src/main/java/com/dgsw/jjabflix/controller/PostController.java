package com.dgsw.jjabflix.controller;

import com.dgsw.jjabflix.entity.PostEntity;
import lombok.RequiredArgsConstructor;
import com.dgsw.jjabflix.dto.UploadRequest;
import com.dgsw.jjabflix.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/item")
    public List<String> item() {
        return service.getPost();
    }

    @GetMapping("/item/{id}")
    public PostEntity findById(@PathVariable Long id) {
        return service.getPost(id);
    }
}
