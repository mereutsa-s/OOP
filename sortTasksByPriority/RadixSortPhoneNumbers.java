package src.main.java.org.example.sortTasksByPriority;

import java.util.Arrays;

public class RadixSortPhoneNumbers {
    public static void countingSort(long[] arr, int exp) {
        int n = arr.length;
        long[] output = new long[n]; // Выходной массив
        int[] count = new int[10]; // Массив для хранения количества элементов для каждой цифры

        // Инициализация массива count
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        // Подсчёт количества номеров телефонов по текущему разряду
        for (int i = 0; i < n; i++) {
            int digit = (int) (arr[i] / exp) % 10; // Получаем текущую цифру
            count[digit]++;
        }

        // Преобразование count[i] в положение count[i] в выходном массиве
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Построение выходного массива
        for (int i = n - 1; i >= 0; i--) {
            int digit = (int) (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Копирование выходного массива в оригинальный массив
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public static long[] sortPhoneNumbers(long[] arr) {
        // Находим максимальное число, чтобы знать, сколько разрядов проверять
        long max = arr[0];
        for (long num : arr) {
            if (num > max) {
                max = num;
            }
        }

        // Выполняем подсчёт по разрядам (exp - экспонента, представляющая текущий разряд)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }

        return arr;
    }

    public static void main(String[] args) {
        long[] phoneNumbers = {9876543210L, 1234567890L, 5555555555L, 1000000000L};
        System.out.println(Arrays.toString(sortPhoneNumbers(phoneNumbers)));
    }
}
