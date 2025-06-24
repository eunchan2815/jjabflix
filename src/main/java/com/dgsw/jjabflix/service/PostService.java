package com.dgsw.jjabflix.service;

import com.dgsw.jjabflix.dto.UploadRequest;
import com.dgsw.jjabflix.entity.PostEntity;
import com.dgsw.jjabflix.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<String> getPost() {
       return repository.findAll().stream().map(PostEntity::getTitle).collect(Collectors.toList());
    }

    public PostEntity getPost(Long id) {
        Optional<PostEntity> entity = repository.findById(id);
        return entity.orElse(null);
    }
}
