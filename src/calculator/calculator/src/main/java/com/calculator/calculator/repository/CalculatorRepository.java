package com.calculator.calculator.repository;


import com.calculator.calculator.model.CalculatorOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorRepository extends JpaRepository<CalculatorOperation, Long> {
}