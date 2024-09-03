package src.main.java.org.example.oop2;

import java.util.LinkedList;
import java.util.Queue;

public class Market implements QueueBehaviour, QueueBehaviour.MarketBehaviour {
    private Queue<String> queue; // Очередь для людей
    private int ordersProcessed;  // Счётчик обработанных заказов

    public Market() {
        this.queue = new LinkedList<>();
        this.ordersProcessed = 0;
    }

    @Override
    public void enqueue(String person) {
        queue.add(person);
        System.out.println(person + " добавлен в очередь.");
    }

    @Override
    public String dequeue() {
        if (!isEmpty()) {
            String person = queue.poll(); // Удаляет и возвращает голову очереди
            System.out.println(person + " вышел из очереди.");
            return person;
        } else {
            System.out.println("Очередь пуста.");
            return null;
        }
    }

    @Override
    public Boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void processOrder() {
        if (!isEmpty()) {
            String person = dequeue(); // Обрабатываем человека
            System.out.println("Обрабатывается заказ для " + person);
            ordersProcessed++;
        } else {
            System.out.println("Нет заказов для обработки.");
        }
    }

    @Override
    public void update() {
        // Здесь обновляем состояние магазина
        // Например, можно обрабатывать заказы и добавлять новых клиентов
        System.out.println("Обновление состояния магазина...");
        processOrder(); // Пример обработки заказа
    }

    public int getOrdersProcessed() {
        return ordersProcessed; // Получаем количество обработанных заказов
    }
}