package com.bookstore.admin.login.dao;

import com.bookstore.commons.beans.User;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/5/11
 */
public interface IAdminUserDao {
    User selectUserByLogin(User user);
}
