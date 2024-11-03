package ru.safiullina;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int f;

    public Filter(int f) {
        this.f = f;
    }

    // Метод List<Integer> filterOut(List<Integer> list) для фильтрации списка
    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        int counter = 0;

        for (int i : source) {
            if(i < f){
                logger.log("Элемент " + i + " не проходит");
            }
            else {
                logger.log("Элемент " + i + " проходит");
                result.add(i);
                counter++;
            }
        }
        logger.log("Прошло фильтр " + counter + " элемента из " + source.size());

        return result;
    }
}
