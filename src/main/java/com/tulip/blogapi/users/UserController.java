package com.tulip.blogapi.users;

import com.tulip.blogapi.users.dto.CreateUserDTO;
import com.tulip.blogapi.users.dto.UserReponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService usersService;

    public UserController(UserService userService)
    {
        this.usersService = userService;
    }

//    @PostMapping("")
//    public ResponseEntity<UserReponseDTO> createUser(@RequestBody CreateUserDTO createUserDTO)
//    {
//
//        var savedUser = userService.createUser(createUserDTO);
//        return ResponseEntity
//                .created(URI.create("/user/" + savedUser.getId()))
//                .body(savedUser);
//    }
    @PostMapping("")
    public ResponseEntity<UserReponseDTO> createUser(@RequestBody CreateUserDTO createUserDTO) {
        var savedUser = usersService.createUser(createUserDTO);
        return ResponseEntity
                .created(URI.create("/users/" + savedUser.getId()))
                .body(savedUser);
    }
}
