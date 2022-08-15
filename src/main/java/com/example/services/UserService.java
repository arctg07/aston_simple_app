package com.example.services;


import com.example.dto.response.UserResponse;
import com.example.mapper.UserMapper;
import com.example.models.User;
import com.example.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper mapper;

    private void checkOutOfBounds(Long id) {
        if (id <= 0) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Wrong id!");
        }
    }

    public List<UserResponse> getAll() {
        return userRepository.all()
                .stream()
                .map(mapper::toResponseFromUser)
                .collect(Collectors.toList());
    }

    public User getById(Long id) {
        checkOutOfBounds(id);

        return userRepository.getById(id);
    }

    public void add(User user) {
        userRepository.add(user);
    }

    public void delete(Long id) {
        checkOutOfBounds(id);
        userRepository.delete(id);
    }
}
