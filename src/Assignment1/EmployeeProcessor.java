package org.assignment1;

import java.util.*;

public class EmployeeProcessor {
    static class Employee {
        String id;
        String name;
        String department;
        double salary;

        public Employee(String id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
    }

    private List<Employee> employees;

    public EmployeeProcessor() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        if (employee.id == null || employee.id.isEmpty() || Double.parseDouble(employee.id) <= 0) {
            throw new IllegalArgumentException("Invalid employee ID");
        }
        if (employee.salary <= 0) {
            throw new IllegalArgumentException("Salary must be greater than 0");
        }

        employees.add(employee);
    }

    public void processEmployeeRecords() {
        // Step 1: Store employee IDs to one collection
        Set<String> employeeIds = new HashSet<>();
        for (Employee employee : employees) {
            employeeIds.add(employee.id);
        }

        // Step 2: Remove duplicate employee IDs if any
        // Already handled while adding to the Set

        // Step 3: Sort the collection based on the employee IDs in descending
        List<String> sortedEmployeeIds = new ArrayList<>(employeeIds);
        Collections.sort(sortedEmployeeIds, Collections.reverseOrder());

        // Step 4: Retrieve employee information and store against each employee ID into another collection
        Map<String, Employee> employeeDetailsMap = new HashMap<>();
        for (Employee employee : employees) {
            if (employeeIds.contains(employee.id)) {
                employeeDetailsMap.put(employee.id, employee);
            }
        }

        // Step 5: Iterate over the collection created above and print the employee details against each employee ID
        for (String id : sortedEmployeeIds) {
            if (employeeDetailsMap.containsKey(id)) {
                System.out.println(employeeDetailsMap.get(id));
            }
        }
    }
}
