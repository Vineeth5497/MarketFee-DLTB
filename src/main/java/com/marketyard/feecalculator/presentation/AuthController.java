package com.marketyard.feecalculator.presentation;

import com.marketyard.feecalculator.entity.Employee;
import com.marketyard.feecalculator.repository.EmployeeRepo;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final EmployeeRepo employeeRepo;

    public AuthController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @PostMapping("/signup")
    public ApiResponse signup(@RequestBody SignupRequest request) {
        try {
            String code = request.employeeCode();
            if (code == null || !(code.trim().equalsIgnoreCase("DLTB-A") || code.trim().equalsIgnoreCase("DLTB-B"))) {
                return ApiResponse.error("Invalid Employee Code. Please enter a valid code (DLTB-A or DLTB-B).", Collections.emptyList());
            }

            Optional<Employee> existing = employeeRepo.findByEmployeeId(request.employeeId());
            if (existing.isPresent()) {
                return ApiResponse.error("Employee ID already exists.", Collections.emptyList());
            }

            Employee emp = new Employee();
            emp.setEmailId(request.emailId());
            emp.setDateOfBirth(request.dateOfBirth());
            emp.setEmployeeId(request.employeeId());
            emp.setEmployeeCode(request.employeeCode());
            emp.setPassword(request.password());

            employeeRepo.save(emp);
            return ApiResponse.success("Signup successful", Collections.emptyList());
        } catch(Exception e) {
            return ApiResponse.error("Error during signup: " + e.getMessage(), Collections.emptyList());
        }
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginRequest request) {
        try {
            Optional<Employee> existing = employeeRepo.findByEmployeeId(request.employeeId());
            if (existing.isPresent()) {
                Employee emp = existing.get();
                if (emp.getPassword().equals(request.password())) {
                    return ApiResponse.success("Login successful", Collections.emptyList());
                } else {
                    return ApiResponse.error("Incorrect password", Collections.emptyList());
                }
            }
            return ApiResponse.error("Employee Not Found", Collections.emptyList());
        } catch(Exception e) {
            return ApiResponse.error("Error during login: " + e.getMessage(), Collections.emptyList());
        }
    }
}
