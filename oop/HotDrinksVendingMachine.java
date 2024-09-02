package src.main.java.org.example.oop;

import java.util.HashMap;
import java.util.Map;

class HotDrinksVendingMachine implements VendingMachine{
    private Map<String, HotDrinkTemperature> drinks;

    public HotDrinksVendingMachine(){
        drinks = new HashMap<>();
    }

    public void addDrink(HotDrinkTemperature drink){
        drinks.put(drink.getName() + drink.getVolume(), drink);
    }

    @Override
    public Product getProduct(String name) {
        return null;
    }

    @Override
    public HotDrinkTemperature getProduct(String name, int volume, int temperature) {
        String key = name + volume;
        HotDrinkTemperature drink = drinks.get(key);
        if (drink != null && drink.getTemperature() == temperature){
            return drink;
        }
        return null;
    }
}
