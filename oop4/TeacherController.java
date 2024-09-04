package src.main.java.org.example.oop4;

import java.util.Scanner;

public class TeacherController {
    private TeacherService teacherService;
    private TeacherView teacherView;
    private Scanner scanner;

    public TeacherController(){
        teacherService = new TeacherService;
        teacherView = new TeacherView;
        Scanner = new Scanner(System.in);
    }
    public void createTeacher() {
        System.out.print("Введите имя учителя: ");
        String name = scanner.nextLine();
        System.out.print("Введите предмет учителя: ");
        String item = scanner.nextLine();
        Teacher teacher = new Teacher(name, item);
        teacherService.addTeacher(teacher);
    }
    public void editTeachers() {
        teacherView.displayTeachers(teacherService.getTeachers());
        System.out.print("Введите индекс учителя для редактирования: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Чтобы поглотить оставшийся символ новой строки
        System.out.print("Введите новое имя учителя: ");
        String name = scanner.nextLine();
        System.out.print("Введите новый предмет учителя: ");
        String item = scanner.nextLine();
        teacher newTeacher = new teacher(name, item);
        teacherService.editTeacher(index, newTeacher);
    }
    public void showTeachers() {
        teacherView.displayTeacher(teacherService.getTeacher());
    }
}
