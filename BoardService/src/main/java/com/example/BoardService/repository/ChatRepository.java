package com.example.BoardService.repository;

import com.example.BoardService.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository <Chat, Long> {
}
