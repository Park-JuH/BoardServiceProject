package com.example.BoardService.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@Setter
public class Chat {

    @Id
    @GeneratedValue
    private Long chat_id;

    public Chat() {
    }

    @NonNull
    private String chatdetail;

    public Chat(Long chat_id, String chatdetail) {
        this.chat_id = chat_id;
        this.chatdetail = chatdetail;
    }
}
