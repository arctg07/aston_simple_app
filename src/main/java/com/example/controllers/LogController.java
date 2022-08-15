package com.example.controllers;

import com.example.dto.request.LogRequest;
import com.example.dto.response.LogResponse;
import com.example.mapper.LogMapper;
import com.example.models.Log;
import com.example.models.User;
import com.example.repositories.LogRepository;
import com.example.services.LogService;
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
@RequestMapping("/logs")
public class LogController {

    private final LogService logService;

    @GetMapping
    public ResponseEntity<List<LogResponse>> all() {
        return ResponseEntity.ok(logService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<LogResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(logService.getById(id));
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody LogRequest request) {
        logService.add(request);
        return ResponseEntity.ok("Add successfully");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> update(@PathVariable Long id) {
        logService.delete(id);
        return ResponseEntity.ok("Delete successfully");
    }
}
