package com.geekbrains.spring.web.core.dictionaries;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class OrderStatusRus {
    private static final HashMap<OrderStatus,String> statusMap = new HashMap<>();

    static {
        statusMap.put(OrderStatus.NEW,"Создан");
        statusMap.put(OrderStatus.PAID,"Оплачен");
        statusMap.put(OrderStatus.CANCELED,"Отменен");
    }

    public static Map<OrderStatus,String> getStatusMap() {
        return Collections.unmodifiableMap(statusMap);
    }
}
