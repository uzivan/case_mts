package ru.croc.javaschool2024.samsonov.factory;

import ru.croc.javaschool2024.samsonov.impl.DeliveryType;
import ru.croc.javaschool2024.samsonov.impl.ProductType;
import ru.croc.javaschool2024.samsonov.order.Order;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class OrderFactory {
    public Order createOrder() {
        int productType = ThreadLocalRandom.current().nextInt(0, 5);
        int count = ThreadLocalRandom.current().nextInt(0, 2);
        LocalDateTime dateTime = LocalDateTime.now();
        int city = ThreadLocalRandom.current().nextInt(0, 1);
        int deliveryType = ThreadLocalRandom.current().nextInt(0, 1);

        Order order = new Order();
        switch (productType) {
            case 0:
                order.setProduct(ProductType.MEAT_PIE);
                break;
            case 1:
                order.setProduct(ProductType.CABBAGE_PIE);
                break;
            case 2:
                order.setProduct(ProductType.FISH_PIE);
                break;
            case 3:
                order.setProduct(ProductType.BERRY_PIE);
                break;
            case 4:
                order.setProduct(ProductType.TEA);
                break;
            case 5:
                order.setProduct(ProductType.COFFEE);
                break;
        }
        order.setCount(count);

        switch (city) {
            case 0:
                order.setCity("Moscow");
                break;
            case 1:
                order.setCity("Saint-Petersburg");
        }
        order.setOrderDate(dateTime);

        switch (deliveryType) {
            case 0:
                order.setDeliveryType(DeliveryType.COURIER);
                break;
            case 1:
                order.setDeliveryType(DeliveryType.PICKUP);
        }

        return order;
    }
}
