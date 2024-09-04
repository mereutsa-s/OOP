package src.main.java.org.example.oop4;

import java.util.ArrayList;

public class TeacherService {
    public class TeacherService {
        private List<Teacher> teachers;

        public TeacherService() {
            teachers = new ArrayList<>();
        }

        public void getTeachers(Teacher teacher) {
            teachers.add(teacher);
        }

        public void editTeachers(int index, Teacher teacher) {
            if (index >= 0 && index < teachers.size()) {
                teachers.set(index, teacher);
            }
        }

        public List<Teacher> getTeachers() {
            return teachers;
        }
}
