package com.marketyard.feecalculator.repository;

import com.marketyard.feecalculator.entity.MarketData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for {@link com.marketyard.feecalculator.entity.MarketData} entities.
 * Provides standard CRUD operations for daily market fee summary records.
 */
@Repository
public interface MarketDataRepo extends JpaRepository<MarketData, Integer> {
}
