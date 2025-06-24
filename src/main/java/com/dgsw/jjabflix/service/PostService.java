package com.dgsw.jjabflix.service;

import com.dgsw.jjabflix.dto.UploadRequest;
import com.dgsw.jjabflix.entity.PostEntity;
import com.dgsw.jjabflix.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;

    public String uploadPost(UploadRequest request) {
        PostEntity entity = new PostEntity();
        entity.setTitle(request.getTitle());
        entity.setContent(request.getContent());
        repository.save(entity);
        return "OK";
    }

    public String deletePost(Long id) {
        Optional<PostEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            repository.deleteById(id);
            return "deleted";
        }
        return "fail";
    }
}
