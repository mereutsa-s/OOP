package src.main.java.org.example.oop;

public class Main {
    public static void main(String[] args) {
        HotDrinksVendingMachine vendingMachine = new HotDrinksVendingMachine();

        vendingMachine.addDrink(new HotDrinkTemperature("Чай", 200, 90));
        vendingMachine.addDrink(new HotDrinkTemperature("Кофе", 150, 85));
        vendingMachine.addDrink(new HotDrinkTemperature("Горячий шоколад", 250, 80));

        HotDrinkTemperature drink1 = vendingMachine.getProduct("Чай", 200, 90);
        HotDrinkTemperature drink2 = vendingMachine.getProduct("Кофе", 150, 85);
        HotDrinkTemperature drink3 = vendingMachine.getProduct("Горячий шоколад", 250, 80);

        if (drink1 != null){
            System.out.println("Вы получили: " + drink1.getName());
        }else {
            System.out.println("Напиток не найден или температура не совподает для Чая.");
        }
        if (drink2 != null){
            System.out.println("Вы получили: " + drink2.getName());
        }else {
            System.out.println("Напиток не найден или температура не совпадает для Кофе.");
        }
        if (drink3 != null){
            System.out.println("Вы получили: " + drink3.getName());
        }else {
            System.out.println("Напиток не найден или температура не совпадает для Горячий шоколад.");
        }
    }
}


//todo Создать наследника реализованного класса ГорячийНапиток с дополнительным полем int температура.

// Создать класс ГорячихНапитковАвтомат реализующий интерфейс ТорговыйАвтомат и реализовать перегруженный метод getProduct(int name, int volume, int temperature), выдающий продукт соответствующий имени, объёму и температуре
// В main проинициализировать несколько ГорячихНапитков и ГорячихНапитковАвтомат и воспроизвести логику, заложенную в программе
// Всё вышеуказанное создать согласно принципам ООП, пройденным на семинаре
// Формат сдачи: