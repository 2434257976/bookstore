package com.bookstore.admin.notices.service;

import com.bookstore.commons.beans.Notice;

import java.util.List;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/5/27
 */
public interface IAdminNoticesService {
    List<Notice> ListNoticeServlet();

    int AddNotice(Notice notice);

    Notice FindNoticeById(String id);

    int modifyNotice(Notice notice);

    int removeNotice(String id);
}
