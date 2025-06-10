package ru.neoflex.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.practice.controller.db.CalculationResult;
import ru.neoflex.practice.controller.repository.CalculationResultRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@CrossOrigin(origins = "*")
@SpringBootApplication
@RestController
public class CalcController {

    @Autowired
    private CalculationResultRepository repository;
    public CalcController(CalculationResultRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CalcController.class, args);
    }

    @GetMapping("/plus/{a}/{b}")
    public int plus(@PathVariable("a") int a, @PathVariable("b") int b) {
        int result = a + b;
        saveCalculation("plus", a, b, result);
        return result;
    }

    @GetMapping("/minus/{a}/{b}")
    public int minus(@PathVariable("a") int a, @PathVariable("b") int b) {
        int result = a - b;
        saveCalculation("minus", a, b, result);
        return result;
    }

    @GetMapping("/calculations")
    public List<CalculationResult> getAllCalculations() {
        return repository.findAll();
    }

    private void saveCalculation(String operation, int operand1, int operand2, int result) {
        CalculationResult calculationResult = new CalculationResult(operation, operand1, operand2, result);
        repository.save(calculationResult);
    }
}