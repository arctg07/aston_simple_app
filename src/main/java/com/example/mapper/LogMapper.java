package com.example.mapper;

import com.example.config.MapperConfig;
import com.example.dto.request.LogRequest;
import com.example.dto.response.LogResponse;
import com.example.models.Log;
import com.example.models.User;
import com.example.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDate;
import java.util.List;

@Mapper(config = MapperConfig.class)
@AllArgsConstructor
public abstract class LogMapper implements MapperConfig {

    @Mapping(target = "message", source = "message")
    public abstract Log toLogFromRequest(LogRequest request);

    public abstract Log toLogResponseInUserFromLog(Log log);

    @AfterMapping
    void setLocalDate(@MappingTarget Log log) {
        log.setDate(LocalDate.now());
    }

    @Mapping(target = "user_id", expression = "java(log.getUser().getId())")
    public abstract LogResponse toResponseFromLog(Log log);

    public abstract List<LogResponse> toListResponse(List<Log> logs);
}

