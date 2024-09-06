package src.main.java.org.example.oop5;

import java.util.List;

public class Controller {
    EducationalGroupService educationalGroupService;

    public Controller(EducationalGroupService educationalGroupService) {
        this.educationalGroupService = educationalGroupService;
    }

    public StudyGroup createStudyGroup(Teacher teacher, List<Student> students) {
        return EducationalGroupService.createStudyGroup(teacher, students);
    }
}
