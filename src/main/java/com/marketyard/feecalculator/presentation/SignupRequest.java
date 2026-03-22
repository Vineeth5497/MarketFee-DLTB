package com.marketyard.feecalculator.presentation;
import java.time.LocalDate;

/**
 * Immutable record representing the payload for a new employee registration (signup) request.
 *
 * @param emailId       The employee's email address.
 * @param dateOfBirth   The employee's date of birth used for identity verification.
 * @param employeeId    The unique employee identifier chosen during registration.
 * @param employeeCode  The company-issued employee code (must be "DLTB-A" or "DLTB-B").
 * @param password      The plain-text password for the new account.
 */
public record SignupRequest(String emailId, LocalDate dateOfBirth, String employeeId, String employeeCode, String password) {}

