package LS5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class BackupUtility {

    public static void main(String[] args) {
        // Укажите путь к директории, которую хотите архивировать
        String sourceDirPath = "./source"; // Замените на необходимый путь
        createBackup(sourceDirPath);

        // Пример массива для игры в крестики-нолики
        int[] ticTacToeState = {0, 1, 2, 2, 1, 0, 0, 1, 0};
        System.out.println("Исходное состояние поля: " + Arrays.toString(ticTacToeState));
    }

    public static void createBackup(String sourceDirPath) {
        File sourceDir = new File(sourceDirPath);
        File backupDir = new File("./backup");

        // Создание директории для резервной копии, если её не существует
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        // Получаем список файлов в директории
        File[] files = sourceDir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Path sourcePath = file.toPath();
                    Path backupPath = backupDir.toPath().resolve(file.getName());
                    try {
                        // Копирование файла в директорию резервной копии
                        Files.copy(sourcePath, backupPath, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Файл " + file.getName() + " скопирован в ./backup");
                    } catch (IOException e) {
                        System.err.println("Ошибка при копировании файла: " + file.getName());
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Директория пуста или не существует.");
        }
    }
}