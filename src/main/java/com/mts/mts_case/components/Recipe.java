package com.mts.mts_case.components;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Класс, представляющий рецепты для приготовления различных блюд
class Recipes {
    private static final Map<String, String[]> recipeMap = new HashMap<>();

    static {
        recipeMap.put("Пирожок с мясом", new String[]{"тесто", "мясо"});
        recipeMap.put("Пирожок с капустой", new String[]{"тесто", "капуста"});
        recipeMap.put("Пирог с рыбой", new String[]{"тесто", "рыба", "рыба"});
        recipeMap.put("Пирог с ягодой", new String[]{"тесто", "тесто", "ягоды", "ягоды"});
        recipeMap.put("Чай", new String[]{"листовой чай"});
        recipeMap.put("Кофе", new String[]{"зерна кофе", "зерна кофе"});
    }


    static String[] getIngredients(String dish) {
        return recipeMap.get(dish);
    }
}

// Класс, представляющий печь для приготовления блюд
class Oven {
    private int capacity;
    private String type;
    private int cookingTime;

    Oven(int capacity, String type, int cookingTime) {
        this.capacity = capacity;
        this.type = type;
        this.cookingTime = cookingTime;
    }

    synchronized void cook(String dish) {
        System.out.println("Печь типа " + type + " приготавливает " + dish);
        try {
            Thread.sleep(cookingTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Готово: " + dish);
    }
}

// Класс, представляющий машину для приготовления напитков
class BeverageMachine {
    private String type;
    private int cookingTime;

    BeverageMachine(String type, int cookingTime) {
        this.type = type;
        this.cookingTime = cookingTime;
    }

    synchronized void brew() {
        System.out.println("Машина для приготовления " + type + " начинает работу");
        try {
            Thread.sleep(cookingTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Готов " + type);
    }
}

// Класс, представляющий систему приготовления продукции
class ProductionSystem {
    private final Oven[] ovens;
    private final BeverageMachine teaMachine;
    private final BeverageMachine coffeeMachine;

    ProductionSystem() {
        ovens = new Oven[]{
                new Oven(10, "большая", 1),
                new Oven(5, "средняя", 2),
                new Oven(2, "маленькая", 3)
        };
        teaMachine = new BeverageMachine("чай", 3);
        coffeeMachine = new BeverageMachine("кофе", 4);
    }

    synchronized void processOrder(String[] orders) {
        ExecutorService executorService = Executors.newFixedThreadPool(orders.length);
        for (String order : orders) {
            executorService.submit(() -> {
                String[] ingredients = Recipes.getIngredients(order);
                if (ingredients != null) {
                    for (String ingredient : ingredients) {
                        System.out.println("Получаем " + ingredient);
                    }
                    System.out.println("Готовим " + order);
                    if (order.equals("Чай")) {
                        teaMachine.brew();
                    } else if (order.equals("Кофе")) {
                        coffeeMachine.brew();
                    } else {
                        for (Oven oven : ovens) {
                            if (oven.capacity >= ingredients.length) {
                                oven.cook(order);
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("Неизвестный заказ: " + order);
                }
            });
        }
        executorService.shutdown();
    }
}

public class Main {
    public static void main(String[] args) {
        ProductionSystem productionSystem = new ProductionSystem();

        String[] orders = {"Пирожок с мясом", "Чай", "Пирог с рыбой", "Кофе"};

        productionSystem.processOrder(orders);
    }
}
