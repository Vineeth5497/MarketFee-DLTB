package com.marketyard.feecalculator.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * JPA entity representing an employee registered in the system.
 * Maps to the "employees" table in the database.
 * Employee credentials are stored here and used for authentication.
 */
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated primary key

    private String emailId;         // Employee's email address

    private LocalDate dateOfBirth;  // Employee's date of birth

    @Column(unique = true, nullable = false)
    private String employeeId;      // Unique employee identifier (e.g. E1001)

    @Column(nullable = false)
    private String employeeCode;    // Company-issued code (DLTB-A or DLTB-B)

    @Column(nullable = false)
    private String password;        // Plain-text password (consider hashing in future versions)

    public Employee() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public String getEmployeeCode() { return employeeCode; }
    public void setEmployeeCode(String employeeCode) { this.employeeCode = employeeCode; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
