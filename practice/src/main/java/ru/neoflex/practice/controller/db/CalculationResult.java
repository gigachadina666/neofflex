package ru.neoflex.practice.controller.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CalculationResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String operation;
    private int operand1;
    private int operand2;
    private int result;

    // Конструкторы, геттеры и сеттеры
    public CalculationResult() {}

    public CalculationResult(String operation, int operand1, int operand2, int result) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public String getOperation() {
        return operation;
    }

    public int getOperand1() {
        return operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public int getResult() {
        return result;
    }
}