package com.mts.mts_case.components;

// Класс, представляющий машину для приготовления напитков
public class BeverageMachine {
    private String type;
    private int cookingTime;

    public BeverageMachine(String type, int cookingTime) {
        this.type = type;
        this.cookingTime = cookingTime;
    }

    /**
     * Приготовить заданный напиток в машине
     */
    public void brew() {
        System.out.println("Машина для приготовления " + type + " начинает работу");
        try {
            Thread.sleep(cookingTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Готов " + type);
    }
}
