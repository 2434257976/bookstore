package com.bookstore.admin.login.service;

import com.bookstore.admin.login.dao.IAdminUserDao;
import com.bookstore.commons.beans.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/5/11
 */
@Service
public class AdminUserServiceIml implements IAdminUserService {
    @Resource
    IAdminUserDao adminUserDao;

    @Override
    public User findUserByLogin(User user) {
        return adminUserDao.selectUserByLogin(user);
    }
}
