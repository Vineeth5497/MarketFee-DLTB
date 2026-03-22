package com.marketyard.feecalculator.presentation;
import java.time.LocalDate;

public record SignupRequest(String emailId, LocalDate dateOfBirth, String employeeId, String employeeCode, String password) {}
