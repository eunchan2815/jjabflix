package com.dgsw.jjabflix.controller;

import com.dgsw.jjabflix.dto.PostResponse;
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

    @GetMapping("/items")
    public List<PostResponse> item() {
        return service.getPost();
    }

    @GetMapping("/items/{id}")
    public PostEntity findById(@PathVariable Long id) {
        return service.getPost(id);
    }

    @PatchMapping("/update")
    public String update(@RequestBody PostEntity request) {
        return service.updatePost(request);
    }
}
