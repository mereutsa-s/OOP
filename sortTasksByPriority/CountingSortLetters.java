package src.main.java.org.example.sortTasksByPriority;

import java.util.Map;
import java.util.TreeMap;

public class CountingSortLetters {
    private static void countLetters(String text){
        // Создание Я TreeMap для хранения количество каждой буквы
        Map<Character, Integer> LetterCount = new TreeMap<>();
        // Преобразование строки в нижний регистр и подсчет букв
        for (char c : text.toLowerCase().toCharArray()){
            //ПРоверяем, является ли символ буквой
            if (Character.isLetter(c)){
                LetterCount.put(c, LetterCount.getOrDefault(c, 0) + 1);
            }
        }
        // Выводрезультата
        for (Map.Entry<Character, Integer> entry : LetterCount.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void main(String[] args){
        String text = "Hello World";
        countLetters(text);
    }
}
