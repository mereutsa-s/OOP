package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            // Создание объектов Person
            Person person1 = new Person("Alice", 30);
            Person person2 = new Person("Bob", 25);
            Person person3 = new Person("Charlie", 28);

            // Сохранение объектов
            session.save(person1);
            session.save(person2);
            session.save(person3);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}