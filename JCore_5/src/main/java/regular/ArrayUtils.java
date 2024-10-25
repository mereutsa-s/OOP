package regular;

public class ArrayUtils {

    // Метод для подсчета четных элементов
    public static int countEvens(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // Метод для нахождения разницы между наибольшим и наименьшим элементами
    public static int differenceBetweenMaxAndMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return max - min;
    }

    // Метод для проверки наличия двух соседних нулей
    public static boolean hasAdjacentZeros(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0 && arr[i + 1] == 0) {
                return true;
            }
        }
        return false;
    }

    // Пример использования методов
    public static void main(String[] args) {
        int[] example1 = {2, 1, 2, 3, 4};
        int[] example2 = {2, 2, 0};
        int[] example3 = {1, 3, 5};
        int[] example4 = {0, 0, 1, 2};

        System.out.println("Количество четных элементов: " + countEvens(example1)); // 3
        System.out.println("Разница между макс и мин: " + differenceBetweenMaxAndMin(example1)); // 2
        System.out.println("Соседние нули: " + hasAdjacentZeros(example4)); // true
        System.out.println("Соседние нули: " + hasAdjacentZeros(example1)); // false
    }
}