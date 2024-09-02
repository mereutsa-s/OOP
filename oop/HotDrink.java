package src.main.java.org.example.oop;

public class HotDrink {
    private String name;
    private int volume;

    public HotDrink(String name, int volume){
        this.name = name;
        this.volume = volume;
    }

    public String getName(){
        return name;
    }
    public int getVolume(){
        return volume;
    }
}
