package com.marketyard.feecalculator.presentation;

import java.util.List;

public record ApiResponse(boolean success, String message, List<String> details) {
    public static ApiResponse success(String message, List<String> details) {
        return new ApiResponse(true, message, details);
    }

    public static ApiResponse error(String message, List<String> details) {
        return new ApiResponse(false, message, details);
    }
}
