package com.bookstore.client.user.service;

import com.bookstore.client.user.dao.IUserDao;
import com.bookstore.commons.beans.Order;
import com.bookstore.commons.beans.OrderItem;
import com.bookstore.commons.beans.User;
import com.bookstore.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/4/8
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserDao userDao;

    @Override
    public int addUser(User user, HttpServletRequest request)  {
        String emailMsg="感谢你注册网上书城，请点击" +
                "<a href='http://localhost:8080/"+request.getContextPath()+"/client/user/activeUser?activeCode="+user.getActiveCode()+"'>激活</a>后使用！";
        try {
            MailUtils.sendMail(user.getEmail(),emailMsg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return userDao.insertUser(user);
    }
    @Override
    public User findEmail(String email) {
        return userDao.selectEmail(email);
    }

    @Override
    public User findUsername(String username) {
        return userDao.selectUsername(username);
    }
    @Override
    public int activeUser(String activeCode) {
        return userDao.activeUser(activeCode);
    }

    @Override
    public User findUserByLogin(User user) {
        return userDao.selectUserByLogin(user);
    }

    @Override
    public int modifyUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public List<Order> findOrderByUser(Integer id) {
        return userDao.selectOrderByUser(id);
    }

    @Override
    public List<OrderItem> findOrderItemById(String id) {
        return userDao.selectOrderItemById(id);
    }

    @Override
    public void removeOrderById(String id, String flag) {
        if (flag==null){
            List<OrderItem> items= userDao.selectOrderItemById(id);
            //加回库存
            for (OrderItem item:items){
                userDao.updateProductpnum(item);
            }
        }
        //删除订单和订单项
        userDao.deleteOrderById(id);
        userDao.deleteOrderItemById(id);


    }


}
