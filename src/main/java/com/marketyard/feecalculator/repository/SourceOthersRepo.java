package com.marketyard.feecalculator.repository;

import com.marketyard.feecalculator.entity.SourceOthers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for {@link com.marketyard.feecalculator.entity.SourceOthers} entities.
 * Provides standard CRUD operations for miscellaneous (Others) source fee records.
 */
@Repository
public interface SourceOthersRepo extends JpaRepository<SourceOthers, Integer> {
}
