package src.main.java.org.example.oop7;

public class Calculator {
    public ComplexNumber calculate(Operation operation, ComplexNumber a, ComplexNumber b){
        LoggerUtil.log("Выполнение операции: " + operation.getClass().getSimpleName());
        return operation.execute(a,b);
    }
}
