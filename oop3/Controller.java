package src.main.java.org.example.oop3;

import java.util.List;

public class Controller {
    private StreamService streamService;

    public Controller(){
        this.streamService = new StreamService();
    }

    public void sortStreamsList(List<Flow> streams){
        streamService.sortStreams(streams);
    }

}
