package com.bookstore.client.user.service;

import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.OrderItem;
import com.bookstore.commons.beans.User;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/4/8
 */
public interface IUserService {
    int addUser(User user, HttpServletRequest request) throws MessagingException;
    User findEmail(String email);
    User findUsername(String username);

    int activeUser(String activeCode);

    User findUserByLogin(User user);

    int modifyUser(User user);

    List<Order> findOrderByUser(Integer id);


    List<OrderItem> findOrderItemById(String id);

    void removeOrderById(String id, String flag);
}






