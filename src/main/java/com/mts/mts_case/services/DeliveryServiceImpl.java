package com.mts.mts_case.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private Map<String, Integer> cities;

    public DeliveryServiceImpl(Map<String, Integer> cities) {
        this.cities = cities;
        SBBDelivery sbbDelivery = new SBBDelivery();
        Thread thread1 = new Thread(sbbDelivery);
        thread1.start();
    }

    @Override
    public void delivery(String city) {

        if (!cities.containsKey(city)) {
            throw new RuntimeException("This city is missing");
        }

        Integer a = cities.get(city);
        cities.put(city, a++);
    }
}
@Component
class SBBDelivery implements Runnable{
    @Autowired
    private Map<String, Integer> cities;
    private Map<Integer, Integer> cars;
    private Map<Integer, Integer> bic;
    private Map<Integer, Integer> walks;

    @Override
    public void run() {
        try {
            while (true) {
                if(cities.get("SPB") > 1) {
                    System.out.println("Delivery in SPB by cars");
                    if(cities.get("SPB") < 40){
                        cities.put("SPB", 0);
                        continue;
                    }
                    else {
                        Integer a = cities.get("SPB");
                        cities.put("SPB", a-40);
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }
    }
}
