package com.example.BoardService.service;

import com.example.BoardService.domain.User;
import com.example.BoardService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long saveUser() {
        User newUser = new User();
        newUser.setUseremail("example@example.com");
        newUser.setAge(30);
        newUser.setUsername("exampleUser");

        User savedUser = userRepository.save(newUser);

        return savedUser.getUser_id();
    }
}
