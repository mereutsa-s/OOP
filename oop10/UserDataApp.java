package src.main.java.org.example.oop10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserDataApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество датарождения номер_телефона пол (разделенные пробелом):");

        try {
            String input = scanner.nextLine();
            String[] data = input.split(" ");

            // Проверка количества введённых данных
            if (data.length != 6) {
                if (data.length < 6) {
                    throw new IllegalArgumentException("Введено меньше данных, чем требуется.");
                } else {
                    throw new IllegalArgumentException("Введено больше данных, чем требуется.");
                }
            }

            // Распаковка данных
            String surname = data[0];
            String name = data[1];
            String patronymic = data[2];
            String birthDateStr = data[3];
            String phoneNumberStr = data[4];
            char gender = data[5].charAt(0);

            // Проверка формата даты
            LocalDate birthDate = parseBirthDate(birthDateStr);
            // Проверка формата номера телефона
            long phoneNumber = parsePhoneNumber(phoneNumberStr);
            // Проверка формата пола
            validateGender(gender);

            // Форматирование строки для записи в файл
            String output = String.format("%s %s %s %s %d %c", surname, name, patronymic, birthDateStr, phoneNumber, gender);

            // Запись в файл
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(surname + ".txt", true))) {
                writer.write(output);
                writer.newLine();
            } catch (IOException e) {
                System.err.println("Ошибка записи в файл: " + e.getMessage());
                e.printStackTrace();
            }

            System.out.println("Данные успешно записаны в файл.");

        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.err.println("Ошибка: неверный формат даты. Ожидался формат dd.mm.yyyy.");
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static LocalDate parseBirthDate(String birthDateStr) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(birthDateStr, formatter);
    }

    private static long parsePhoneNumber(String phoneNumberStr) {
        // Проверка, что номер телефона является целым беззнаковым числом
        try {
            long phoneNumber = Long.parseLong(phoneNumberStr);
            if (phoneNumber < 0) {
                throw new IllegalArgumentException("Номер телефона должен быть положительным целым числом.");
            }
            return phoneNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Номер телефона должен быть целым беззнаковым числом.");
        }
    }

    private static void validateGender(char gender) {
        if (gender != 'f' && gender != 'm') {
            throw new IllegalArgumentException("Пол должен быть 'f' или 'm'.");
        }
    }
}