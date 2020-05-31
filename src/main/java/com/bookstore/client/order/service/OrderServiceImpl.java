package com.bookstore.client.order.service;

import com.bookstore.client.order.dao.IOrderDao;
import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.OrderItem;
import com.bookstore.commons.beans.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/4/26
 */
@Service
public class OrderServiceImpl implements IOrderService{
    @Resource
    IOrderDao orderDao;
    @Override
    public void CreateOrder(Order order, Map<Product, Integer> cart) {
        OrderItem orderItem=new OrderItem();
        //循环插入该订单项对应的订单信息,并修改商品的库存。
        for (Product p:cart.keySet()){
            orderItem.setProduct(p);
            orderItem.setOrder(order);
            orderItem.setBuynum(cart.get(p));
            //插入订单项
           orderDao.insertOrderItem(orderItem);
           //修改商品库存
            orderDao.updateProductnum(orderItem);
       }
        // if (1==1){
        //     int a=1/0;
        // }
        //插入订单orders对应的信息
        orderDao.insertOrder(order);
    }

    @Override
    public void paySuccess(String order_id) {
        orderDao.updatePaystate(order_id);
    }


}
