package Assignment3;


import java.util.*;
import java.util.stream.Collectors;
public class Employee_StreamApi {
        public static void main(String[] args) {
            try {
                List<Employee> employees = createEmployeeList();

                // 1. Total number of employees in the company.
                long totalEmployees = employees.size();
                System.out.println("Total number of employees: " + totalEmployees);

                // 2. Group the employees based on the department.
                Map<String, List<Employee>> employeesByDepartment = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));
                System.out.println("Employees grouped by department: " + employeesByDepartment);

                // 3. Total salary paid to all the employees.
                double totalSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
                System.out.println("Total salary paid to all employees: " + totalSalary);

                // 4. Total salary paid to employees of each department.
                Map<String, Double> totalSalaryByDepartment = employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));
                System.out.println("Total salary paid to employees of each department: " + totalSalaryByDepartment);

                // 5. Sort the employees based on age.
                List<Employee> employeesSortedByAge = employees.stream()
                        .sorted(Comparator.comparingInt(Employee::getAge))
                        .toList();
                System.out.println("Employees sorted by age: " + employeesSortedByAge);

                // 6. Sort the employees based on experience.
                List<Employee> employeesSortedByExperience = employees.stream()
                        .sorted(Comparator.comparingInt(Employee::getExperience))
                        .toList();
                System.out.println("Employees sorted by experience: " + employeesSortedByExperience);
            } catch (InputMismatchException e) {
                System.out.println("Input mismatch exception: Please enter valid input.");
            }
        }

        static List<Employee> createEmployeeList() throws InputMismatchException {
            Scanner scanner = new Scanner(System.in);
            List<Employee> employees = new ArrayList<>();

            try {
                System.out.println("Enter number of employees:");
                int numEmployees = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                for (int i = 0; i < numEmployees; i++) {
                    System.out.println("Enter name of employee " + (i + 1) + ":");
                    String name = scanner.nextLine();

                    System.out.println("Enter age of employee " + (i + 1) + ":");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Enter experience of employee " + (i + 1) + ":");
                    int experience = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Enter salary of employee " + (i + 1) + ":");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    System.out.println("Enter department of employee " + (i + 1) + ":");
                    String department = scanner.nextLine();

                    employees.add(new Employee(name, age, experience, salary, department));
                }
            } catch (InputMismatchException e) {
                throw e; // Rethrow the exception for handling in the main method
            } finally {
                scanner.close(); // Close the scanner in the finally block
            }

            return employees;
        }
    }

    class Employee {
        private final String name;
        private final int age;
        private final int experience;
        private final double salary;
        private final String department;

        public Employee(String name, int age, int experience, double salary, String department) {
            this.name = name;
            this.age = age;
            this.experience = experience;
            this.salary = salary;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getExperience() {
            return experience;
        }

        public double getSalary() {
            return salary;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", experience=" + experience +
                    ", salary=" + salary +
                    ", department='" + department + '\'' +
                    '}';
        }
    }

