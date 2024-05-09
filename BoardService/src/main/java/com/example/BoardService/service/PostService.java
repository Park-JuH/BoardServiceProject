package com.example.BoardService.service;

import com.example.BoardService.domain.Post;
import com.example.BoardService.domain.User;
import com.example.BoardService.repository.PostRepository;
import com.example.BoardService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Long savePost(Long userId) {

        User user = userRepository.findById(userId).orElse(null);  // UserRepository를 사용하여 User 찾기
        if (user == null) {
            throw new IllegalStateException("User not found");  // 사용자가 없는 경우 예외 처리
        }

        Post newPost = new Post();
        newPost.setPostname("Hello");
        newPost.setPostdetail("Hello my name is blablabla");
        newPost.setPostimg("");
        newPost.setUser(user);

        Post savedPost = postRepository.save(newPost);

        return savedPost.getPost_id();
    }

    public List<Post> findAllPost() {
        return postRepository.findAll();
    }
}
