package com.projeto.CadastrodeUsuario.service;

import com.projeto.CadastrodeUsuario.Dto.CreateUserDto;
import com.projeto.CadastrodeUsuario.Dto.UpdateUserDto;
import com.projeto.CadastrodeUsuario.Repository.UserRepository;
import com.projeto.CadastrodeUsuario.entity.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(CreateUserDto createUserDto) {
        var entity = new User(
                createUserDto.username(),
                createUserDto.email(),
                createUserDto.password(),
                Instant.now(),
                null
        );
        var userSaved = userRepository.save(entity);
        return userSaved.getId();
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(UUID.fromString(String.valueOf(id)));
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public void updateUserById(String id, UpdateUserDto updateUserDto) {
     var userExists = userRepository.findById(UUID.fromString(id));
     if(userExists.isPresent()) {
         var user = userExists.get();

         if (updateUserDto.username() != null) {
             user.setUsername(updateUserDto.username());
         }

         if(updateUserDto.password() != null) {
             user.setPassword(updateUserDto.password());
         }

         userRepository.save(user);

     }
    }


    public void deleteById(String id) {
      var userExists = userRepository.existsById(UUID.fromString(id));
        if (userExists) {
            userRepository.deleteById(UUID.fromString(id));
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
}


