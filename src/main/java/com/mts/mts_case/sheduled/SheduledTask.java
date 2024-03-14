package ru.croc.javaschool2024.samsonov.sheduled;

import ru.croc.javaschool2024.samsonov.factory.OrderFactory;
import ru.croc.javaschool2024.samsonov.order.Order;

import java.util.LinkedList;
import java.util.Queue;

@Component
@RequiredArgsConstructor
public class SheduledTask {
    private OrderFactory orderFactory;
    public Queue<String> queue;

    @Scheduled(fixedRate = 15000)
    public void reportCurrentTime() {
        Order newOrder = OrderFactory.createOrder();
        queue.add(newOrder);
    }
}
