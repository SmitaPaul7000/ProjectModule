package com.tulip.blogapi.users;

import com.tulip.blogapi.articles.ArticleEntity;
import com.tulip.blogapi.commons.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity(name = "users")
public class UserEntity extends BaseEntity {

    String username;
    String password; // TO Do hash it
    String bio;
    String image;
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
