package com.marketyard.feecalculator.repository;

import com.marketyard.feecalculator.entity.SourceGovt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for {@link com.marketyard.feecalculator.entity.SourceGovt} entities.
 * Provides standard CRUD operations for Government source fee records.
 */
@Repository
public interface SourceGovtRepo extends JpaRepository<SourceGovt, Integer> {
}
