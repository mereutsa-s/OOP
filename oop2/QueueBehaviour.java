package src.main.java.org.example.oop2;

public interface QueueBehaviour {
    void enqueue (String person);
    String dequeue();
    Boolean isEmpty();


    public interface MarketBehaviour {
        void processOrder();
        void update();
    }
}
