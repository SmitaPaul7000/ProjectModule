package com.tulip.blogapi.users;

import com.tulip.blogapi.users.dto.CreateUserDTO;
import com.tulip.blogapi.users.dto.LoginUserDTO;
import com.tulip.blogapi.users.dto.UserReponseDTO;
import org.apache.tomcat.jni.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/login")
    public ResponseEntity<UserReponseDTO> loginUser(@RequestBody LoginUserDTO loginUserDTO) {
        var savedUser = usersService.loginUser(loginUserDTO);
        return ResponseEntity.ok(savedUser);

    }

    @ExceptionHandler(UserService.UserNotFoundException.class)
    public ResponseEntity<String> handleUserNitFoundException(UserService.UserNotFoundException e)
    {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e)
    {
        return ResponseEntity.badRequest().body(e.getMessage());
    }


    }
