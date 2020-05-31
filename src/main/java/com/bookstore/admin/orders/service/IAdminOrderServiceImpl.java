package com.bookstore.admin.orders.service;

import com.bookstore.admin.orders.dao.IAdminOrderDao;
import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.OrderItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/5/28
 */
@Service
public class IAdminOrderServiceImpl implements IAdminOrderService {

    @Resource
    IAdminOrderDao adminOrderDao;

    @Override
    public List<Order> findOrders() {
        return adminOrderDao.selectOrders();
    }

    @Override
    public List<Order> findOrderByManyCondition(Order order) {
        return adminOrderDao.selectOrderByManyCondition(order);
    }

    @Override
    public List<OrderItem> findOrderItemById(String id) {
        return adminOrderDao.selectOrderItemById(id);
    }

    @Override
    public int removeOrderItemById(String id) {
       adminOrderDao.deleteOrderItemById(id);
        return adminOrderDao.deleteOrderById(id);
    }
}
