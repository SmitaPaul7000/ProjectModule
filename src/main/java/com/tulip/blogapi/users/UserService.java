package com.tulip.blogapi.users;

import com.tulip.blogapi.users.dto.CreateUserDTO;
import com.tulip.blogapi.users.dto.LoginUserDTO;
import com.tulip.blogapi.users.dto.UserReponseDTO;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public UserService(UserRepository userRepository, ModelMapper modelMapper)
    {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserReponseDTO createUser(CreateUserDTO createUserDTO)
    {
//            var newUserEntity =  new UserEntity();
//            newUserEntity.setEmail(createUserDTO.getEmail());

        //TO Do:
        var newUserEntity = modelMapper.map(createUserDTO , UserEntity.class);
        var savedUser = userRepository.save(newUserEntity);
        var userResponseDTO = modelMapper.map(savedUser, UserReponseDTO.class);
        return userResponseDTO;

    }
//    public ResponseEntity<UserRes>
    public UserReponseDTO loginUser(LoginUserDTO loginUserDTO)
    {
        var userEntity = userRepository.findByUsername(loginUserDTO.getUsername());

        if(userEntity == null)
        {
            throw new UserNotFoundException(loginUserDTO.getUsername());
        }
        // TO Do encrypt password
        if(!userEntity.getPassword().equals(loginUserDTO.getPassword()))
        {
            throw new IllegalIdentifierException("Incorrect Password");
        }

        var userResponseDTO = modelMapper.map(userEntity, UserReponseDTO.class);

        return  userResponseDTO;
    }

    public static  class UserNotFoundException extends IllegalIdentifierException{

        public UserNotFoundException(Integer id)
        {
            super("User with id " + id + " not found");
        }

        public UserNotFoundException(String userName) {
            super("User with username " + userName + " not found");
        }
    }

    public static class IncorrectPasswordException extends IllegalArgumentException
    {
        public IncorrectPasswordException()
        {
            super("Incorrect Password");
        }
    }

}
