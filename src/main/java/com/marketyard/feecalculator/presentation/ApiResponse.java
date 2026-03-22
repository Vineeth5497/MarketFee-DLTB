package com.marketyard.feecalculator.presentation;

import java.util.List;

/**
 * Immutable record representing a standardized API response structure.
 * Used consistently across all REST endpoints to wrap success/failure status,
 * a human-readable message, and an optional list of detail strings.
 *
 * @param success  {@code true} if the operation succeeded; {@code false} otherwise.
 * @param message  A short summary of the outcome.
 * @param details  An optional list of additional information (e.g., validation errors, status messages).
 */
public record ApiResponse(boolean success, String message, List<String> details) {

    /**
     * Factory method to create a successful API response.
     *
     * @param message A success message to communicate to the client.
     * @param details An optional list of additional detail messages.
     * @return A new {@link ApiResponse} with {@code success = true}.
     */
    public static ApiResponse success(String message, List<String> details) {
        return new ApiResponse(true, message, details);
    }

    /**
     * Factory method to create a failed/error API response.
     *
     * @param message An error message to communicate to the client.
     * @param details An optional list of error detail strings (e.g., field validation errors).
     * @return A new {@link ApiResponse} with {@code success = false}.
     */
    public static ApiResponse error(String message, List<String> details) {
        return new ApiResponse(false, message, details);
    }
}
