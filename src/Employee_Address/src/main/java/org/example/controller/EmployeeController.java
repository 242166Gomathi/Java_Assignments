package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.Address;
import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @Operation(summary = "Create a new employee")
    @ApiResponse(responseCode = "201", description = "Employee created", content = @Content(schema = @Schema(implementation = Employee.class)))
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing employee")
    @ApiResponse(responseCode = "200", description = "Employee updated", content = @Content(schema = @Schema(implementation = Employee.class)))
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an employee by ID")
    @ApiResponse(responseCode = "204", description = "Employee deleted")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "Get all employees")
    @ApiResponse(responseCode = "200", description = "List of employees", content = @Content(schema = @Schema(implementation = Employee.class)))
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/department/{department}")
    @Operation(summary = "Retrieve employees by department")
    @ApiResponse(responseCode = "200", description = "List of employees", content = @Content(schema = @Schema(implementation = Employee.class)))
    public ResponseEntity<Page<Employee>> getEmployeesByDepartment(
            @PathVariable String department,
            Pageable pageable) {
        Page<Employee> employees = employeeService.getEmployeesByDepartment(department, pageable);
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/{employeeId}/addresses")
    @Operation(summary = "Add address to an employee")
    @ApiResponse(responseCode = "200", description = "Employee with added address", content = @Content(schema = @Schema(implementation = Employee.class)))
    public ResponseEntity<Employee> addAddressToEmployee(
            @PathVariable Long employeeId,
            @Valid @RequestBody Address address) {
        Employee employee = employeeService.addAddressToEmployee(employeeId, address);
        return ResponseEntity.ok(employee);
    }
}
