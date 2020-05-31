package com.bookstore.client.order.dao;

import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.OrderItem;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/4/26
 */
public interface IOrderDao {
    void insertOrder(Order order);

    void insertOrderItem(OrderItem orderItem);

    void updateProductnum(OrderItem orderItem);

    void updatePaystate(String order_id);


}










