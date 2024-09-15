package src.main.java.org.example.oop7;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        ComplexNumber num1 = new ComplexNumber(3, 2);
        ComplexNumber num2 = new ComplexNumber(1, 7);

        ComplexNumber resultAddition = calculator.calculate(new Addition(), num1, num2);
        System.out.println("Сложение: " + resultAddition);

        ComplexNumber resultMultiplication = calculator.calculate(new Addition(), num1, num2);
        System.out.println("Умножение: " + resultMultiplication);

        ComplexNumber resultDivision = calculator.calculate(new Division(), num1, num2);
        System.out.println("Деление: " + resultDivision);
    }
}
