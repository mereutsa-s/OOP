package src.main.java.org.example.oop4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TeacherController controller = new TeacherController();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Добавить учителя");
            System.out.println("2. Редактировать учителя");
            System.out.println("3. Показать учителей");
            System.out.println("0. Выход");
            choice = scanner.nextInt();
            scanner.nextLine(); // Чтобы поглотить оставшийся символ новой строки

            switch (choice) {
                case 1:
                    controller.createTeacher();
                    break;
                case 2:
                    controller.editTeachers();
                    break;
                case 3:
                    controller.showTeachers();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        } while (choice != 0);
        scanner.close();
    }
}
