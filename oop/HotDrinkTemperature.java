package src.main.java.org.example.oop;

public class HotDrinkTemperature extends HotDrink {
    private int temperature;

    public HotDrinkTemperature(String name, int volume, int temperature) {
        super(name, volume);
        this.temperature = temperature;
    }
    public int getTemperature(){
        return temperature;
    }
}
