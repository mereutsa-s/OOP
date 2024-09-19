package src.main.java.org.example.oop8;

public class NumberConverter {

    public int convertAndSum(String[] numbers) {
        int sum = 0;

        for (String numberStr : numbers) {
            try {
                int number = Integer.parseInt(numberStr);
                sum += number;

                // Проверяем, превышает ли сумма 100
                if (sum > 100) {
                    throw new ArithmeticException("Превышен лимит суммы");
                }
            } catch (NumberFormatException e) {
                // Если не удалось преобразовать строку в число, выбрасываем исключение
                throw new NumberFormatException("Некорректный формат числа: " + numberStr);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        NumberConverter converter = new NumberConverter();
        String[] numbers = {"10", "20", "30", "40"};

        try {
            int result = converter.convertAndSum(numbers);
            System.out.println("Сумма чисел: " + result);
        } catch (NumberFormatException | ArithmeticException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}