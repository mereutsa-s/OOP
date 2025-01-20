package org.example;

import javax.persistence.*;
import java.util.List;

public class PersonRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");

    public void addPerson(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(person);

        em.getTransaction().commit();
        em.close();
    }

    public Person findPerson(Long id) {
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, id);
        em.close();
        return person;
    }

    public List<Person> findAllPersons() {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
        em.close();
        return persons;
    }

    public void updatePerson(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(person);

        em.getTransaction().commit();
        em.close();
    }

    public void deletePerson(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Person person = em.find(Person.class, id);
        if (person != null) {
            em.remove(person);
        }

        em.getTransaction().commit();
        em.close();
    }
}