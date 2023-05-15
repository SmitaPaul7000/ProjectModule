package com.tulip.blogapi.users;

import com.tulip.blogapi.users.dto.CreateUserDTO;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UsersServiceTests {
    @Autowired
    private UserRepository usersRepository;
    private UserService usersService;

    private UserService getUsersService() {
        if (usersService == null) {
            var modelMapper = new ModelMapper();
            usersService = new UserService(
                    usersRepository,
                    modelMapper
            );
        }
        return usersService;
    }


    @Test
    public void testCreateUser() {
        var newUserDTO = new CreateUserDTO();
        newUserDTO.setEmail("arnav@email.com");
        newUserDTO.setPassword("password");
        newUserDTO.setUsername("arnav123");
        var savedUser = getUsersService().createUser(newUserDTO);
        assertNotNull(savedUser);
    }
}
