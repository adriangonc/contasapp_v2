package com.contas.appcontas.error;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {
    private final int statusCode;
    private final List<ApiError> errors;

    static ErrorResponse of (HttpStatus status, List<ApiError> errors){
        return new ErrorResponse(status.value(), errors);
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @RequiredArgsConstructor
    static class ApiError { //Somente classes aninhadas podem ter modificador static
        private final String code;
        private final String message;
    }
}
