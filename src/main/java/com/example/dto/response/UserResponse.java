package com.example.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Setter
@Getter
public class UserResponse {

    private Long id;

    private String name;

    private List<LogResponse> logs;
}
