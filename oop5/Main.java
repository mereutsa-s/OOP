package src.main.java.org.example.oop5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("1", "Иванов Илександр");
        List<Student> students = new ArrayList<>();
        students.add(new Student("1", "Петр Петрович"));
        students.add(new Student("2","Фомин Александр"));

        EducationalGroupService service = new EducationalGroupService();
        Controller controller = new Controller(service);

        StudyGroup studyGroup = controller.createStudyGroup(teacher, students);
        System.out.println("Учебная группа создана с преподавателем" + studyGroup.getTeacher().getName());
        System.out.println("Студенты в группе: ");
        for (Student student : studyGroup.getStudents()){
            System.out.println("- " + student.getName());
        }
    }
}
