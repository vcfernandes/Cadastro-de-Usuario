package com.projeto.CadastrodeUsuario.controller;


import com.projeto.CadastrodeUsuario.Dto.CreateUserDto;
import com.projeto.CadastrodeUsuario.Dto.UpdateUserDto;
import com.projeto.CadastrodeUsuario.entity.User;
import com.projeto.CadastrodeUsuario.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        var userId = userService.createUser(createUserDto);
        return ResponseEntity.created(URI.create("/v1/users/" + userId.toString())).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        var user = userService.getUserById(UUID.fromString(id));
               if(user.isPresent()) {
                   return ResponseEntity.ok(user.get());
               } else {
                   return ResponseEntity.notFound().build();
               }
    }

    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        var users = userService.listUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUserById(@PathVariable("id") String id, @RequestBody UpdateUserDto updateUserDto) {
        userService.updateUserById(id, updateUserDto);
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}