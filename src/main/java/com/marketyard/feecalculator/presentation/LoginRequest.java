package com.marketyard.feecalculator.presentation;

/**
 * Immutable record representing the payload for a login request.
 *
 * @param employeeId The unique identifier of the employee attempting to log in.
 * @param password   The plain-text password submitted by the employee.
 */
public record LoginRequest(String employeeId, String password) {}

