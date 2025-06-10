package ru.neoflex.practice.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.practice.controller.db.CalculationResult;


public interface CalculationResultRepository extends JpaRepository<CalculationResult, Long> {
}