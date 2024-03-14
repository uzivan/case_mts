package ru.croc.javaschool2024.samsonov.order;

import ru.croc.javaschool2024.samsonov.impl.DeliveryType;
import ru.croc.javaschool2024.samsonov.impl.ProductType;

import java.time.LocalDateTime;

public class Order {
    public ProductType product;
    public int count;
    public LocalDateTime orderDate;
    public String city;
    public DeliveryType deliveryType;

    public void setProduct(ProductType product) {
        this.product = product;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
}
