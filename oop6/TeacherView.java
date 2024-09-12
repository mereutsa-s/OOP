package src.main.java.org.example.oop6;
import java.util.List;

public class TeacherView {

    public void displayTeachers(List<Teacher> teachers) {
        if (teachers.isEmpty()) {
            System.out.println("Нет учителей для отображения.");
        } else {
            for (int i = 0; i < teachers.size(); i++) {
                System.out.println(i + ": " + teachers.get(i));
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}