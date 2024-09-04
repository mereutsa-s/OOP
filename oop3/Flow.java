package src.main.java.org.example.oop3;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Flow implements Iterable<StudyGroup> {
    private List<StudyGroup> studyGroups;

    public Flow() {
        this.studyGroups = new ArrayList<>();
    }

    public void addGroup(StudyGroup group) {
        studyGroups.add(group);
    }

    public int numberOfGroups() {
        return studyGroups.size();
    }

    @Override
    public Iterator<StudyGroup> iterator() {
        return studyGroups.iterator();
    }
}
