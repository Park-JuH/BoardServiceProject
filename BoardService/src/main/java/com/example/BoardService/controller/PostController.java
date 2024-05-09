package com.example.BoardService.controller;

import com.example.BoardService.domain.Post;
import com.example.BoardService.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("makePost/{id}")
    public ResponseEntity<Long> makePost(@PathVariable("id") Long userId) {
        Long postId = postService.savePost(userId);
        return ResponseEntity.ok(postId);  // 상태 코드 200과 함께 userId 반환
    }

    @GetMapping("viewAll")
    public ResponseEntity<List<Post>> viewAllPost() {
        List<Post> allPost = postService.findAllPost();
        return ResponseEntity.ok(allPost);  // 상태 코드 200과 함께 userId 반환
    }

}
