package com.tulip.blogapi.users.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserReponseDTO {
    Integer id;
    String email;
    String username;
    String bio;
    String image;
    String token;
}