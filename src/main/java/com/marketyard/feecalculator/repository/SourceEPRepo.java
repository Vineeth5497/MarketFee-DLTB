package com.marketyard.feecalculator.repository;

import com.marketyard.feecalculator.entity.SourceEP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceEPRepo extends JpaRepository<SourceEP, Integer> {
}
