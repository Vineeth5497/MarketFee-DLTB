package com.marketyard.feecalculator.repository;

import com.marketyard.feecalculator.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data JPA repository for
 * {@link com.marketyard.feecalculator.entity.Employee} entities.
 * Provides standard CRUD operations and a custom query method to look up
 * employees by their ID.
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    /**
     * Finds an employee by their unique employee identifier.
     *
     * @param employeeId The employee's unique ID string (e.g. "E1001").
     * @return An {@link Optional} containing the found {@link Employee}, or empty
     *         if not found.
     */
    Optional<Employee> findByEmployeeId(String employeeId);
}
