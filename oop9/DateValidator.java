package src.main.java.org.example.oop9;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator {

    public static String validateDate(String dateStr) {
        // Определяем формат даты
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            // Пробуем преобразовать строку в дату
            LocalDate date = LocalDate.parse(dateStr, formatter);

            // Проверяем, находится ли дата в пределах от 0001-01-01 до 9999-12-31
            if (date.getYear() < 1 || date.getYear() > 9999) {
                return "Ошибка: год должен быть в диапазоне от 0001 до 9999.";
            }

            // Если все проверки пройдены, возвращаем дату в нужном формате
            return date.format(formatter);

        } catch (DateTimeParseException e) {
            return "Ошибка: введенная строка не является корректной датой в формате YYYY-MM-DD.";
        }
    }

    public static void main(String[] args) {
        // Примеры использования метода
        String date1 = "2023-10-05";
        String date2 = "2023-13-01"; // некорректная дата
        String date3 = "9999-12-31";
        String date4 = "0000-12-31"; // некорректная дата

        System.out.println(validateDate(date1)); // вывод: 2023-10-05
        System.out.println(validateDate(date2)); // вывод: Ошибка: введенная строка не является корректной датой в формате YYYY-MM-DD.
        System.out.println(validateDate(date3)); // вывод: 9999-12-31
        System.out.println(validateDate(date4)); // вывод: Ошибка: год должен быть в диапазоне от 0001 до 9999.
    }
}
