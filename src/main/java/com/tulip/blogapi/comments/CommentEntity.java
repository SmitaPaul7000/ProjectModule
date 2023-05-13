package com.tulip.blogapi.comments;

import com.tulip.blogapi.articles.ArticleEntity;
import com.tulip.blogapi.commons.BaseEntity;
import com.tulip.blogapi.users.UserEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name = "comments")
public class CommentEntity extends BaseEntity {

    @Column(nullable = false, length = 200)
    String title;

    @Column( length = 1000)
    String body;

    @ManyToOne
    UserEntity author;

    @ManyToOne
    ArticleEntity article;
}
