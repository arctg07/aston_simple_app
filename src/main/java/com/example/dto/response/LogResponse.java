package com.example.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@RequiredArgsConstructor
@Setter
@Getter
public class LogResponse {

    private String message;

    private Long user_id;

    private LocalDate date;
}
