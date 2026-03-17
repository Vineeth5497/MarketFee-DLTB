package com.marketyard.feecalculator.repository;

import com.marketyard.feecalculator.entity.SourceOthers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceOthersRepo extends JpaRepository<SourceOthers, Integer> {
}
