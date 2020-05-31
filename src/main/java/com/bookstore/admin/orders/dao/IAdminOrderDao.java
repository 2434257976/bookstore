package com.bookstore.admin.orders.dao;

import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.OrderItem;

import java.util.List;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/5/28
 */
public interface IAdminOrderDao {
    List<Order> selectOrders();

    List<Order> selectOrderByManyCondition(Order order);

    List<OrderItem> selectOrderItemById(String id);

    void deleteOrderItemById(String id);

    int deleteOrderById(String id);
}
