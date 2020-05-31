package com.bookstore.admin.orders.handler;

import com.bookstore.admin.orders.service.IAdminOrderService;
import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/5/28
 */
@Controller
@RequestMapping("/admin/orders")
public class AdminOrderHandler {

    @Autowired
    IAdminOrderService adminOrderService;

    //查询所有订单
    @RequestMapping("/findOrders")
    public String findOrders(Model model){
       List<Order> orders=adminOrderService.findOrders();
        // for (Order order : orders) {
        //     System.out.println(order);
        // }
        model.addAttribute("orders",orders);
       return "/admin/orders/list.jsp";
    }

    //按收件人，订单号精确查询
    @RequestMapping("/findOrderByManyCondition")
    public String findOrderByManyCondition(Order order,Model model){
        List<Order>orders= adminOrderService.findOrderByManyCondition(order);
        model.addAttribute("orders",orders);
       // System.out.println(orders);
            return "/admin/orders/list.jsp";
    }

    //查看订单详细信息
    @RequestMapping("/findOrderById")
    public String findOrderItemById(String id,Model model){
        List<OrderItem> items=adminOrderService.findOrderItemById(id);
        model.addAttribute("items",items);
        //System.out.println(items);
        return "/admin/orders/view.jsp";
    }

    //删除订单和订单项
    @RequestMapping("/removeOrderItemById")
    public String removeOrderItemById(String id){
        int rows= adminOrderService.removeOrderItemById(id);
        if (rows>0){
            //System.out.println(id);
            return "redirect:/admin/orders/findOrders";
        }else {
            return "/admin/orders/error.jsp";
        }


    }

}
