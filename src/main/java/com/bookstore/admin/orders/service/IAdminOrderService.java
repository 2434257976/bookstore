package com.bookstore.admin.orders.service;

import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.OrderItem;


import java.util.List;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/5/28
 */

public interface IAdminOrderService {
    List<Order> findOrders();

    List<Order> findOrderByManyCondition(Order order);

    List<OrderItem> findOrderItemById(String id);

    int removeOrderItemById(String id);
}
