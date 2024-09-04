package src.main.java.org.example.oop3;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StreamService {
    public void sortStreams(List<Flow> streams){
        Collections.sort(streams, new StreamComparator());
    }
}
