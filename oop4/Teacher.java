package src.main.java.org.example.oop4;

public class Teacher {
    private String name;
    private String item;

    public Teacher(String name, String item) {
        this.name = name;
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public String getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Учитель{" +
                "имя='" + name + '\'' +
                ", предмет='" + item + '\'' +
                '}';
    }
}