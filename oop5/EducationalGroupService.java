package src.main.java.org.example.oop5;

import java.util.List;

public class EducationalGroupService {
    public static StudyGroup createStudyGroup(Teacher teacher, List<Student> students){
        return new StudyGroup(students, teacher);
    }
}
