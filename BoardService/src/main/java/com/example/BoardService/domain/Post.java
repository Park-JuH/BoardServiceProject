package com.example.BoardService.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue
    private Long post_id;
    @NonNull
    private String postname;
    @NonNull
    private String postdetail;
    private String postimg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // 외래 키로 사용될 컬럼 지정
    @JsonIgnore
    private User user; // 이 포스트를 작성한 사용자

    public Post() {
    }

    public Post(Long post_id, String postname, String postdetail, String postimg) {
        this.post_id = post_id;
        this.postname = postname;
        this.postdetail = postdetail;
        this.postimg = postimg;
        this.user = user;
    }
}
