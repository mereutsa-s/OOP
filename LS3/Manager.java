package LS3;

import java.util.List;

class Manager extends Employee {

    public Manager(String name, double salary) {
        super(name, salary);
    }

    // Статический метод повышения зарплаты для всех сотрудников, кроме руководителей
    public static void raiseSalaries(List<Employee> employees, double percentage) {
        for (Employee employee : employees) {
            // Увеличиваем зарплату только если это не руководитель
            int isManager = employee instanceof Manager ? 1 : 0;
            employee.setSalary(employee.getSalary() * (1 + percentage * isManager));
        }
    }
}