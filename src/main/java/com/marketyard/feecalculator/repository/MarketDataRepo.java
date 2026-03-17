package com.marketyard.feecalculator.repository;

import com.marketyard.feecalculator.entity.MarketData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketDataRepo extends JpaRepository<MarketData, Integer> {
}
