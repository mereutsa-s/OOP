package src.main.java.org.example.oop6;

public class Main {
    public static void main(String[] args) {
        TeacherService teacherService = new TeacherService();
        TeacherView teacherView = new TeacherView();
        TeacherController teacherController = new TeacherController(teacherService, teacherView);

        teacherController.start();
    }
}