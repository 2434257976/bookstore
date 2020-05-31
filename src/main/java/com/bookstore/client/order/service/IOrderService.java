package com.bookstore.client.order.service;

import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.Product;

import java.util.Map;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/4/26
 */


public interface IOrderService {

    void CreateOrder(Order order, Map<Product, Integer> cart);

    void paySuccess(String order_id);


}






