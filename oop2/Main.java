package src.main.java.org.example.oop2;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        market.enqueue("Клиент 1");
        market.enqueue("Клиент 2");

        market.update(); // Обновляем состояние магазина
        market.update(); // Обновляем снова для обработки следующего заказа

        market.enqueue("Клиент 3");
        market.update(); // Обрабатываем ещё один заказ

        System.out.println("Всего обработано заказов: " + market.getOrdersProcessed());
    }
}
