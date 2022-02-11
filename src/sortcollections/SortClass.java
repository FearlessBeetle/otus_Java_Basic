package sortcollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class SortClass {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            arrayList.add((int) (Math.random() * 100));
        }

        // Пузырьковая сортировка
        SortFunc sort1 = (array) -> {
            for (int i = array.size() - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (array.get(j) > array.get(j + 1)) {
                        int temp = array.get(j);
                        array.set(j, array.get(j + 1));
                        array.set(j + 1, temp);
                    }
                }

            }
        };


        Date startTime = new Date();
        System.out.println("Время начала пузырьковой сортировки :" + startTime);
        sort1.sortFunc(arrayList);
        long endTime = ((new Date().getTime()) - startTime.getTime()) / 1000;
        System.out.println("Длительность пузырьковой сортировки :" + endTime);


        startTime = new Date();
        System.out.println("Время начала встроенной сортировки :" + startTime);
        Collections.sort(arrayList);
        endTime = ((new Date().getTime()) - startTime.getTime()) / 1000;
        System.out.println("Длительность встроенной сортировки :" + endTime +
                "секунд");



    }

}
