package src.main.java.org.example.sortTasksByPriority;

import java.util.Arrays;

public class HeapSortTasks {
    public static void heapify(int[] arr, int n, int i){
        int largest = i; // Инициализируем наибольший элемент как корень
        int left = 2 * i + 1; // Левая дочерняя вершина
        int right = 2 * i + 2; // Правая дочерняя вершина
        // Если левый дочерний элемент больше корня
        if (left < n && arr[left] > arr[largest]){
            largest = left;
        }
        // Если правый дочерний элемент больше, чем крупнейший элемент на данный момент
        if (right < n && arr[right] > arr[largest]){
            largest = right;
        }
        // Если крупнейший элемент не корень
        if (largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Рекурсивно преобразуем затронутое поддерево в кучу
            heapify(arr, n, largest);
        }
    }
    public static int[] sortTasksByPriority(int[] tasks){
        int n = tasks.length;
        // Построение кучи (переписывание массива в двоичную кучу)
        for (int i = n / 2 - 1; i >= 0; i--){
            heapify(tasks, n, i);
        }
        // Один за одним извлекаем элементы из кучи
        for (int i = n - 1; i > 0; i --){
            // Перемещаем текущий корень в конец
            int temp = tasks[0];
            tasks[0] = tasks[i];
            tasks[i] = temp;
            // Вызываем heapify на уменьшенной куче
            heapify(tasks, i, 0);
        }
        return  tasks;
    }
    public static void main(String[] args){
        int[] tasks = {3, 1, 4, 2, 5};
        System.out.println(Arrays.toString(sortTasksByPriority(tasks)));
    }
}
