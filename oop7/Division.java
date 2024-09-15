package src.main.java.org.example.oop7;

public class Division implements Operation {
    @Override
    public ComplexNumber execute(ComplexNumber a, ComplexNumber b) {
        double denominator = b.getReal() * b.getImaginary() + b.getImaginary() * b.getReal();
        if (denominator == 0){
            throw new ArithmeticException("Деление на ноль");
        }
        double real = (a.getReal() * b.getReal() + a.getImaginary() * b.getImaginary() / denominator);
        double imaginary = (a.getImaginary() * b.getReal() - a.getReal() * b.getImaginary()) / denominator;
        return new ComplexNumber(real, imaginary);
    }
}
