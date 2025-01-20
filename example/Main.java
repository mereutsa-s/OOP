package org.example;

public class Main {
    public static void main(String[] args) {
        PersonRepository repository = new PersonRepository();

        // Создание нового лица
        Person alice = new Person("Alice", 30);
        repository.addPerson(alice);

        // Поиск лица по ID
        Person foundAlice = repository.findPerson(1L);
        System.out.println(foundAlice);

        // Обновление возраста
        foundAlice.setAge(31);
        repository.updatePerson(foundAlice);

        // Получение всех лиц
        List<Person> allPersons = repository.findAllPersons();
        System.out.println("All persons: " + allPersons);

        // Удаление лица
        repository.deletePerson(1L);
    }
}