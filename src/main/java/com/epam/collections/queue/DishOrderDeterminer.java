package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {

        List<Integer> dishes = new ArrayList<>();
        for (int i = 1; i <= numberOfDishes; i++) {
            dishes.add(i);
        }

        ArrayList<Integer> eatingOrder = new ArrayList<>();
        int currentIndex = 0;
        while (!dishes.isEmpty()) {
            currentIndex = (currentIndex + everyDishNumberToEat - 1) % dishes.size();
            eatingOrder.add(dishes.get(currentIndex));
            dishes.remove(currentIndex);
        }

        return eatingOrder;
    }
}
