package src.main.java.org.example.oop6;

import java.util.Scanner;

public class TeacherController {
    private TeacherService teacherService;
    private TeacherView teacherView;
    private Scanner scanner;

    public TeacherController(TeacherService teacherService, TeacherView teacherView) {
        this.teacherService = teacherService;
        this.teacherView = teacherView;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Выберите действие: 1. Добавить учителя 2. Просмотреть учителей 3. Выйти");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очищаем буфер

            switch (choice) {
                case 1:
                    System.out.println("Введите имя учителя:");
                    String name = scanner.nextLine();
                    System.out.println("Введите предмет:");
                    String subject = scanner.nextLine();
                    Teacher teacher = new Teacher(name, subject);
                    teacherService.addTeacher(teacher);
                    break;
                case 2:
                    teacherView.displayTeachers(teacherService.getAllTeachers());
                    break;
                case 3:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}