package com.marketyard.feecalculator.repository;

import com.marketyard.feecalculator.entity.SourceGovt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceGovtRepo extends JpaRepository<SourceGovt, Integer> {
}
