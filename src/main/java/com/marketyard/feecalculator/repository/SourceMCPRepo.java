package com.marketyard.feecalculator.repository;

import com.marketyard.feecalculator.entity.SourceMCP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceMCPRepo extends JpaRepository<SourceMCP, Integer> {
}
