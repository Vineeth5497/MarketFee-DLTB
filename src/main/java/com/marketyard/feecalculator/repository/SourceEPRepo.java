package com.marketyard.feecalculator.repository;

import com.marketyard.feecalculator.entity.SourceEP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for
 * {@link com.marketyard.feecalculator.entity.SourceEP} entities.
 * Provides standard CRUD operations for EP source fee records.
 */
@Repository
public interface SourceEPRepo extends JpaRepository<SourceEP, Integer> {
}
