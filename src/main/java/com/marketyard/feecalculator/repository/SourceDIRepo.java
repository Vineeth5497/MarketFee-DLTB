package com.marketyard.feecalculator.repository;

import com.marketyard.feecalculator.entity.SourceDI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceDIRepo extends JpaRepository<SourceDI, Integer> {

}
