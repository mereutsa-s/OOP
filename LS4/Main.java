package LS4;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Анна", Gender.FEMALE),
                new Employee("Иван", Gender.MALE),
                new Employee("Мария", Gender.FEMALE),
                new Employee("Сергей", Gender.MALE)
        };

        congratulateEmployees(employees);
    }

    public static void congratulateEmployees(Employee[] employees) {
        LocalDate today = LocalDate.now();
        Holiday holiday = determineHoliday(today);

        for (Employee employee : employees) {
            switch (holiday) {
                case NEW_YEAR:
                    System.out.println("С Новым Годом, " + employee.getName() + "!");
                    break;
                case MARCH_8:
                    if (employee.getGender() == Gender.FEMALE) {
                        System.out.println("С 8 марта, " + employee.getName() + "!");
                    }
                    break;
                case FEBRUARY_23:
                    if (employee.getGender() == Gender.MALE) {
                        System.out.println("С 23 февраля, " + employee.getName() + "!");
                    }
                    break;
                default:
                    // Ничего не делаем, если праздник не установлен
                    break;
            }
        }
    }

    public static Holiday determineHoliday(LocalDate date) {
        if (date.getMonthValue() == 1 && date.getDayOfMonth() == 1) {
            return Holiday.NEW_YEAR;
        } else if (date.getMonthValue() == 3 && date.getDayOfMonth() == 8) {
            return Holiday.MARCH_8;
        } else if (date.getMonthValue() == 2 && date.getDayOfMonth() == 23) {
            return Holiday.FEBRUARY_23;
        } else {
            return Holiday.NONE;
        }
    }
}