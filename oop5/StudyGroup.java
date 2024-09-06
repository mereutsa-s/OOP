package src.main.java.org.example.oop5;
import java.util.List;

public class StudyGroup {
    private final Teacher teacher;
    private List<Student> students;

    public StudyGroup(List<Student> students, Teacher teacher) {
        this.students = students;
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
