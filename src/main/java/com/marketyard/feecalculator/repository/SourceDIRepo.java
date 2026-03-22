package com.marketyard.feecalculator.repository;

import com.marketyard.feecalculator.entity.SourceDI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/**
 * Spring Data JPA repository for {@link com.marketyard.feecalculator.entity.SourceDI} entities.
 * Provides standard CRUD operations for D.I source fee records.
 */
public interface SourceDIRepo extends JpaRepository<SourceDI, Integer> {

}
