package com.tulip.blogapi.users.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginUserDTO {
//    String email;
    String username;
    String password;
}
