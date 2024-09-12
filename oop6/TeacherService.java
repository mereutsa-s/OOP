package src.main.java.org.example.oop6;

import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    private List<Teacher> teachers = new ArrayList<>();

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void editTeacher(int index, Teacher teacher) {
        if (index >= 0 && index < teachers.size()) {
            teachers.set(index, teacher);
        } else {
            System.out.println("Учитель не найден.");
        }
    }

    public List<Teacher> getAllTeachers() {
        return teachers;
    }
}