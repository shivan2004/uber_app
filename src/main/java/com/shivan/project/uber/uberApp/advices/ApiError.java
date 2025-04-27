package com.shivan.project.uber.uberApp.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ApiError {
    private HttpStatus statusCode;
    private String message;
    private List<String> subErrors;
}
