package com.example.springsecurityexample.demo.repository;

import com.example.springsecurityexample.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
