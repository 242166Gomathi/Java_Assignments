package com.calculator.calculator.controller;

import com.calculator.calculator.model.CalculatorOperation;
import com.calculator.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/add")
    public ResponseEntity<CalculatorOperation> add(@RequestParam Double num1, @RequestParam Double num2) {
        CalculatorOperation operation = calculatorService.performOperation("add", num1, num2);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    @PostMapping("/subtract")
    public ResponseEntity<CalculatorOperation> subtract(@RequestParam Double num1, @RequestParam Double num2) {
        CalculatorOperation operation = calculatorService.performOperation("subtract", num1, num2);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    @PostMapping("/multiply")
    public ResponseEntity<CalculatorOperation> multiply(@RequestParam Double num1, @RequestParam Double num2) {
        CalculatorOperation operation = calculatorService.performOperation("multiply", num1, num2);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    @PostMapping("/divide")
    public ResponseEntity<CalculatorOperation> divide(@RequestParam Double num1, @RequestParam Double num2) {
        CalculatorOperation operation = calculatorService.performOperation("divide", num1, num2);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }
}