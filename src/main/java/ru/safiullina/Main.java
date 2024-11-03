package ru.safiullina;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем/получаем логгер
        Logger logger = Logger.getInstance();
        // Пишем первый лог
        logger.log("Запускаем программу");

        try {

            // Создаем сканер
            Scanner scanner = new Scanner(System.in);
            logger.log("Просим пользователя ввести входные данные для списка");
            System.out.print("Введите размер списка: ");
            String input = scanner.nextLine();
            int range = Integer.parseInt(input);
            System.out.print("Введите верхнюю границу для значений: ");
            input = scanner.nextLine();
            int maxValue = Integer.parseInt(input);
            if (range < 1 || maxValue < 1) {
                throw new IllegalArgumentException(
                        ((range < 0) ? " размер списка " : "")
                        + ((maxValue < 0) ? " максимальное значение " : "")
                        + "не может быть отрицательным");
            }

            // Создаём и наполняем список
            logger.log("Создаём и наполняем список");
            List<Integer> arrayList = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < range; i++) {
                arrayList.add(random.nextInt(maxValue));
            }
            System.out.print("Вот случайный список: ");
            arrayList.forEach((s) -> System.out.printf(s + " "));
            System.out.println();

            // Просим пользователя ввести входные данные для фильтрации
            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.print("Введите порог для фильтра: ");
            input = scanner.nextLine();
            int f = Integer.parseInt(input);

            // Запускаем фильтрацию
            logger.log("Запускаем фильтрацию");
            Filter filter = new Filter(f);
            List<Integer> results = filter.filterOut(arrayList);
            // Выводим результат на экран
            logger.log("Выводим результат на экран");
            System.out.print("Отфильтрованный список: ");
            for (int result : results) {
                System.out.printf(result + " ");
            }
            System.out.println();
        }
        catch (NumberFormatException e){
            logger.log("Введите целое число. " + e.getMessage());
        }
        catch (IllegalArgumentException e){
            logger.log("Ошибка ввода числа: " + e.getMessage());
        }
        // Завершаем программу
        logger.log("Завершаем программу");
    }
}