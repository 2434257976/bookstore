package com.bookstore.admin.notices.dao;

import com.bookstore.commons.beans.Notice;

import java.util.List;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/5/27
 */
public interface IAdminNoticesDao {
    List<Notice> ListNoticeServlet();

    int insertNotice(Notice notice);

    Notice selectNoticeById(String id);

    int updateNoticeById(Notice notice);

    int deleteNotice(String id);
}
