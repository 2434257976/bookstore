package com.bookstore.client.user.dao;

import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.OrderItem;
import com.bookstore.commons.beans.User;

import java.util.List;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/4/8
 */
public interface IUserDao {
    int insertUser(User user);

    User selectEmail(String email);
    User selectUsername(String username);

    int activeUser(String activeCode);

    User selectUserByLogin(User user);

    int updateUser(User user);


    List<Order> selectOrderByUser(Integer id);


    List<OrderItem> selectOrderItemById(String id);

    void deleteOrderById(String id);

    void deleteOrderItemById(String id);

    void updateProductpnum(OrderItem item);
}















