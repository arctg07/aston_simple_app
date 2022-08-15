package com.example.mapper;

import com.example.config.MapperConfig;
import com.example.dto.response.UserResponse;
import com.example.models.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", config = MapperConfig.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {LogMapper.class})
public abstract class UserMapper implements MapperConfig {

    public abstract UserResponse toResponseFromUser(User user);

    public abstract List<UserResponse> toListResponse(List<User> list);

}

