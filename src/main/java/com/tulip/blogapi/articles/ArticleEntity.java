package com.tulip.blogapi.articles;

import com.tulip.blogapi.commons.BaseEntity;
import com.tulip.blogapi.users.UserEntity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "articles")
public class ArticleEntity extends BaseEntity {
//    String author;
    @Column(unique = true, nullable = false)
    String slug;
    @Column(length = 200,nullable = false)
    String title;
    String subtitle;
    @Column(length = 8000,nullable = false)
    String body;
//    String[] tagList;
//    boolean favorities;
//    int favCount;
//    String author;
    @ManyToOne
    UserEntity autor;

    @ManyToMany
            @JoinTable(
                    name="article_likes",
                    joinColumns = @JoinColumn(name = "article_id"),
                    inverseJoinColumns = @JoinColumn(name = "user_id")
            )
    List<UserEntity> likedBy;
}
