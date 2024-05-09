package com.example.BoardService.controller;

import com.example.BoardService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("signup")
    public ResponseEntity<Long> signUp() {
        Long userId = userService.saveUser();
        return ResponseEntity.ok(userId);  // 상태 코드 200과 함께 userId 반환
    }
}
