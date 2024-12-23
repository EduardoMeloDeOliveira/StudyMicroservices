package com.ms.user.controller;

import com.ms.user.dtos.UserRecordDTO;
import com.ms.user.models.UserModel;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserRecordDTO> createUser(@RequestBody @Valid  UserRecordDTO user, UriComponentsBuilder ucBuilder) {
        UserRecordDTO createdUser = userService.createUser(user);
        URI uri = ucBuilder.path("/users/{id}").build(createdUser.id());
        return ResponseEntity.created(uri).body(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRecordDTO> getUser(@PathVariable UUID id) {

        return ResponseEntity.ok(userService.getUserById(id));
    }
}
