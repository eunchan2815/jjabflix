package com.dgsw.jjabflix.repository;

import com.dgsw.jjabflix.entity.PostEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
