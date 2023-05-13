package com.tulip.blogapi.commons;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Getter
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    @CreatedDate()
    @Column(name = "created_at", updatable = false)
    Date createdAt;
}
