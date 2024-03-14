package com.mts.mts_case.components;
import java.util.HashMap;
import java.util.Map;

// Класс, представляющий рецепты для приготовления различных блюд
public class Recipes {
    private static final Map<String, String[]> recipeMap = new HashMap<>();

    static {
        recipeMap.put("Пирожок с мясом", new String[]{"тесто", "мясо"});
        recipeMap.put("Пирожок с капустой", new String[]{"тесто", "капуста"});
        recipeMap.put("Пирог с рыбой", new String[]{"тесто", "рыба", "рыба"});
        recipeMap.put("Пирог с ягодой", new String[]{"тесто", "тесто", "ягоды", "ягоды"});
        recipeMap.put("Чай", new String[]{"листовой чай"});
        recipeMap.put("Кофе", new String[]{"зерна кофе", "зерна кофе"});
    }

    /**
     * Получить ингредиенты для заданного блюда
     *
     * @param dish наименование блюда
     * @return массив строк, представляющих ингредиенты для приготовления блюда
     */
    public static String[] getIngredients(String dish) {
        return recipeMap.get(dish);
    }
}
