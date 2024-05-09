package com.example.BoardService.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id @GeneratedValue
    private Long user_id;
    @NonNull
    private String useremail;
    @NonNull
    private int age;
    @NonNull
    private String username;

    @OneToMany(mappedBy = "user") // Post 엔티티의 'user' 필드에 의해 매핑됨
    private List<Post> posts; // 사용자가 작성한 포스트 목록

    public User(Long user_id, String useremail, int age, String username) {
        this.user_id = user_id;
        this.useremail = useremail;
        this.age = age;
        this.username = username;
    }

    public User() {

    }
}
