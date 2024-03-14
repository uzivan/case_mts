package com.mts.mts_case.components;

// Класс, представляющий печь для приготовления блюд
public class Oven {
    private int capacity;
    private String type;
    private int cookingTime;

    public Oven(int capacity, String type, int cookingTime) {
        this.capacity = capacity;
        this.type = type;
        this.cookingTime = cookingTime;
    }

    /**
     * Приготовить заданное блюдо в печи
     *
     * @param dish наименование блюда
     */
    public void cook(String dish) {
        System.out.println("Печь типа " + type + " приготавливает " + dish);
        try {
            Thread.sleep(cookingTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Готово: " + dish);
    }
}
