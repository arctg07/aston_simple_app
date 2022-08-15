package com.example.services;

import com.example.dto.request.LogRequest;
import com.example.dto.response.LogResponse;
import com.example.mapper.LogMapper;
import com.example.models.Log;
import com.example.repositories.LogRepository;
import com.example.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;

    private final UserRepository userRepository;

    private final LogMapper mapper;

    private void checkOutOfBounds(Long id) {
        if(id <= 0) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Wrong id!");
        }
    }
    public List<LogResponse> getAll() {
        return logRepository.all()
                .stream()
                .map(mapper::toResponseFromLog)
                .collect(Collectors.toList());
    }

    public LogResponse getById(Long id) {
        checkOutOfBounds(id);
        return mapper.toResponseFromLog(logRepository.getById(id));
    }

    public void add(LogRequest request) {
        Log log = mapper.toLogFromRequest(request);
        log.setUser(userRepository.getById(request.getUser_id()));
        logRepository.add(log);
    }

    public void delete(Long id) {
        checkOutOfBounds(id);
        logRepository.delete(id);
    }
}
