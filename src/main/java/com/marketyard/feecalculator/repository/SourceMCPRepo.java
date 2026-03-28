package com.marketyard.feecalculator.repository;

import com.marketyard.feecalculator.entity.SourceMCP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for
 * {@link com.marketyard.feecalculator.entity.SourceMCP} entities.
 * Provides standard CRUD operations for MCP source fee records.
 */
@Repository
public interface SourceMCPRepo extends JpaRepository<SourceMCP, Integer> {
}
