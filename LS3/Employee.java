package LS3;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Метод для сравнения дат
    public static int compareDates(int year1, int month1, int day1, int year2, int month2, int day2) {
        return (year1 - year2) * 10000 + (month1 - month2) * 100 + (day1 - day2);
    }
}