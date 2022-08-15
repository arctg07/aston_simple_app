package com.example.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LogRequest {

    private String message;
    private Long user_id;
}
