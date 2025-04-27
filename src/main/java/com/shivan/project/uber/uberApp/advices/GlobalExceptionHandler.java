package com.shivan.project.uber.uberApp.advices;


//import com.springSecurity.exceptions.ResourceNotFoundException;
//import io.jsonwebtoken.JwtException;
import com.shivan.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.shivan.project.uber.uberApp.exceptions.RuntimeConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError), apiError.getStatusCode());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ApiError apiError = ApiError.builder()
                .statusCode(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(RuntimeConflictException.class)
    public ResponseEntity<ApiResponse<?>> handleRuntimeConflictException(RuntimeConflictException exception) {
        ApiError apiError = ApiError.builder()
                .statusCode(HttpStatus.CONFLICT)
                .message(exception.getMessage())
                .build();
        return buildErrorResponseEntity(apiError);
    }
//
//    @ExceptionHandler(AuthenticationException.class)
//    public ResponseEntity<ApiError> handleAuthenticationException(AuthenticationException ex) {
//        ApiError apiError = new ApiError(ex.getLocalizedMessage(), HttpStatus.UNAUTHORIZED);
//        return new ResponseEntity<>(apiError, HttpStatus.FORBIDDEN);
//    }
//
//    @ExceptionHandler(JwtException.class)
//    public ResponseEntity<ApiError> handleJwtException(JwtException ex) {
//        ApiError apiError = new ApiError(ex.getLocalizedMessage(), HttpStatus.UNAUTHORIZED);
//        return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
//    }
//
//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<ApiError> handleAccessDeniedException(AccessDeniedException ex) {
//        ApiError apiError = new ApiError(ex.getLocalizedMessage(), HttpStatus.FORBIDDEN);
//        return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
//    }

}
