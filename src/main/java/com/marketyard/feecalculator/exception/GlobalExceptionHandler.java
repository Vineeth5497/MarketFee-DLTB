package com.marketyard.feecalculator.exception;

import com.marketyard.feecalculator.presentation.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Global exception handler that intercepts exceptions thrown across all controllers.
 * Provides centralized error handling, converting exceptions into structured
 * {@link ApiResponse} objects with appropriate HTTP status codes.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles validation failures triggered by {@code @Valid} on request bodies.
     * Extracts all field-level validation error messages and returns them as a
     * 400 Bad Request response.
     *
     * @param ex The exception containing field validation error details.
     * @return A 400 Bad Request response with a list of validation error messages.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.toList());
        log.warn("Validation failed: {}", errors);
        return ResponseEntity.badRequest()
                .body(ApiResponse.error("Validation failed", errors));
    }

    /**
     * Handles any unhandled exceptions not caught by more specific handlers.
     * Returns a generic 500 Internal Server Error response.
     *
     * @param ex The unhandled exception.
     * @return A 500 Internal Server Error response with a generic error message.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGenericException(Exception ex) {
        log.error("Unexpected error", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("An unexpected error occurred. Please try again.", List.of()));
    }
}
