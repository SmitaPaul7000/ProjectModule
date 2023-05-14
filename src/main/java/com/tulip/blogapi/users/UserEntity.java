package com.tulip.blogapi.users;

import com.tulip.blogapi.articles.ArticleEntity;
import com.tulip.blogapi.commons.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
@Getter
@Setter
public class UserEntity extends BaseEntity {

    @Column(unique = true, nullable = false, length = 50)
    String username;
    String password; // TODO: Hash this
    String email;
    String bio;
    String image;

    @ManyToMany(mappedBy = "likedBy")
    List<ArticleEntity> likedArticles;

    @ManyToMany
    @JoinTable(
            name="user_follower",
            joinColumns = @JoinColumn(name = "follower_id"),
            inverseJoinColumns = @JoinColumn(name = "following_id")
    )
    List<UserEntity> following;


    @ManyToMany(mappedBy = "following")
    List<UserEntity> followers;
}
