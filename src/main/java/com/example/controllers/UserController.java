package com.example.controllers;

import com.example.dto.response.UserResponse;
import com.example.models.User;
import com.example.repositories.UserRepository;
import com.example.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> all() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody User user) {
        userService.add(user);
        return ResponseEntity.ok("Add successfully");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok("Delete successfully");
    }
}
