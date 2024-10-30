package LS3;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        // Создаем сотрудников
        employees.add(new Employee("Alice", 50000));
        employees.add(new Employee("Bob", 60000));
        employees.add(new Manager("Charlie", 80000));

        // Печатаем зарплаты до повышения
        System.out.println("Зарплаты до повышения:");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + ": " + employee.getSalary());
        }

        // Повышаем зарплаты на 10%
        Manager.raiseSalaries(employees, 0.10);

        // Печатаем зарплаты после повышения
        System.out.println("\nЗарплаты после повышения:");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + ": " + employee.getSalary());
        }
    }
}
