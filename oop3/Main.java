package src.main.java.org.example.oop3;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Flow flow1 = new Flow();
        flow1.addGroup(new StudyGroup("Группа A1"));
        flow1.addGroup(new StudyGroup("Группа A2"));

        Flow flow2 = new Flow();
        flow2.addGroup(new StudyGroup("Группа B1"));

        Flow flow3 = new Flow();
        flow3.addGroup(new StudyGroup("Группа C1"));
        flow3.addGroup(new StudyGroup("Группа C2"));
        flow3.addGroup(new StudyGroup("Группа C3"));

        List<Flow> streams = new ArrayList<>();
        streams.add(flow1);
        streams.add(flow2);
        streams.add(flow3);

        Controller controller = new Controller();
        controller.sortStreamsList(streams);

        // Печать результата
        for (Flow flow : streams) {
            System.out.println("Количество групп в потоке: " + flow.numberOfGroups());
        }
    }
}
