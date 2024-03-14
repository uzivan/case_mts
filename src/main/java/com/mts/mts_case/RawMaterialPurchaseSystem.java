package com.mts.mts_case;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//public class RawMaterialPurchaseSystem {
//
//
//    /***
//     * Создание Map в которой храняться <товры для закупки, время которое нужно потратить на их закупки>
//     */
//    private static final Map<String, Integer> purchaseTimes = new HashMap<>();
//
//    static {
//
//        purchaseTimes.put("Dough", 1);
//        purchaseTimes.put("Meat", 2);
//        purchaseTimes.put("Cabbage", 2);
//        purchaseTimes.put("Fish", 3);
//        purchaseTimes.put("Berry", 5);
//        purchaseTimes.put("TeaLeaves", 2);
//        purchaseTimes.put("CoffeeBeans", 2);
//    }
//
//
//    /***
//     *
//     * @param type Вид товара(его название) для закупки
//     * @param quantity колличество товара на закуп
//     *
//     *  Функция реализует закупку материала рассчитывая задержку относительно колличетва товара на закуп
//     */
//    public static void purchaseRawMaterial(String type, int quantity) {
//        if (purchaseTimes.containsKey(type)) {
//            int purchaseTime = purchaseTimes.get(type);
//            int totalTime = purchaseTime * quantity;
//            System.out.println("Purchase " + type + " amount " + quantity + " pieces...");
//            try {
//                Thread.sleep(totalTime * 1000); // Имитация времени закупки
//                System.out.println("Type " + type + " Access purchase.");
//            } catch (InterruptedException e) {
//                System.err.println("Purchase execution interrupted " + type);
//                Thread.currentThread().interrupt();
//            }
//        }
//        else {
//            System.err.println("Unknown raw material type: " + type);
//        }
//    }
//
//    public static void main(String[] args) {
//        // Пример использования системы закупки сырья
//        purchaseRawMaterial("Dough", 10);
//        purchaseRawMaterial("Meat", 5);
//        purchaseRawMaterial("Berry", 3);
//    }
//}


public class RawMaterialPurchaseSystem {
    private static final Properties purchaseTimes = new Properties();

    static {
        try {
            purchaseTimes.load(new FileInputStream("raw_materials.properties"));
        } catch (IOException e) {
            System.err.println("Error uploading file raw_materials.properties: " + e.getMessage());
        }
    }
        /***
     *
     * @param type Вид товара(его название) для закупки
     * @param quantity колличество товара на закуп
     *
     *  Функция реализует закупку материала рассчитывая задержку относительно колличетва товара на закуп
     */
    public static void purchaseRawMaterial(String type, int quantity) throws IllegalArgumentException {
        if (purchaseTimes.containsKey(type)) {
            int purchaseTime = Integer.parseInt(purchaseTimes.getProperty(type));
            int totalTime = purchaseTime * quantity;
            System.out.println("Purchase " + type + " amount " + quantity + " pieces...");
            try {
                Thread.sleep(totalTime * 1000);
                System.out.println("Type " + type + " Access purchase.");
            } catch (InterruptedException e) {
                System.err.println("Purchase execution interrupted " + type);
                Thread.currentThread().interrupt();
            }
        } else {
            throw new IllegalArgumentException("Unknown raw material type: " + type);
        }
    }

    public static void main(String[] args) {
        Properties purchaseRequests = new Properties();
        try {
            purchaseRequests.load(new FileInputStream("purchase_requests.properties"));
            for (String type : purchaseRequests.stringPropertyNames()) {
                int quantity = Integer.parseInt(purchaseRequests.getProperty(type));
                purchaseRawMaterial(type, quantity);
            }
        } catch (IOException e) {
            System.err.println("Error uploading file purchase_requests.properties: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error when purchasing raw materials: " + e.getMessage());
        }
    }

}
