package Assignment3;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Employee_FI {
    static class Employee {
        int id;
        String name;
        double salary;
        String skill;

        public Employee(int id, String name, double salary, String skill) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.skill = skill;
        }

        @Override
        public String toString() {
            return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", salary=" + salary + ", skill='" + skill + '\'' + '}';
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Shreya", 40000, "Java"));
        employees.add(new Employee(2, "Gomathi", 65000, "Java"));
        employees.add(new Employee(3, "Anjana", 50000, "Python"));
        employees.add(new Employee(4, "Anusha", 45000, "Python"));

        Optional<List<Employee>> pythonEmployees = Optional.of(employees.stream()
                .filter(employee -> "Python".equals(employee.skill))
                .collect(Collectors.toList()));

        pythonEmployees.ifPresentOrElse(
                employees1 -> {
                    System.out.println("Employees with skill Python:");
                    employees1.forEach(System.out::println);
                },
                () -> {
                    throw new RuntimeException("No employees with skill Python");
                }
        );
    }
}