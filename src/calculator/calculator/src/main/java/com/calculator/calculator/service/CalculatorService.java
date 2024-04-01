package com.calculator.calculator.service;


import com.calculator.calculator.model.CalculatorOperation;
import com.calculator.calculator.repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    @Autowired
    private CalculatorRepository calculatorRepository;

    public CalculatorOperation performOperation(String operation, Double num1, Double num2) {
        Double result;
        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                result = num1 / num2;
                break;
            default:
                throw new UnsupportedOperationException("Invalid operation");
        }

        CalculatorOperation calculatorOperation = new CalculatorOperation();
        calculatorOperation.setOperation(operation);
        calculatorOperation.setNum1(num1);
        calculatorOperation.setNum2(num2);
        calculatorOperation.setResult(result);
        return calculatorRepository.save(calculatorOperation);
    }
}