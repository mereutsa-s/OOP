package src.main.java.org.example.oop4;

public class TeacherView {
    public void displayTeacher(List<Teacher> teachers) {
        if (teachers.isEmpty()) {
            System.out.println("Список учителей пуст.");
            return;
        }
        System.out.println("Список учителей:");
        for (teacher teacher : teachers) {
            System.out.println(teacher);
        }
}
