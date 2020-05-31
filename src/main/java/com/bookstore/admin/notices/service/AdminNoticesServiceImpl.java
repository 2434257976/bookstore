package com.bookstore.admin.notices.service;


import com.bookstore.admin.notices.dao.IAdminNoticesDao;
import com.bookstore.commons.beans.Notice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/5/27
 */
@Service
public class AdminNoticesServiceImpl implements IAdminNoticesService {

    @Resource
    IAdminNoticesDao adminNoticesDao;

    @Override
    public List<Notice> ListNoticeServlet() {
        return adminNoticesDao.ListNoticeServlet();
    }

    @Override
    public int AddNotice(Notice notice) {

        return adminNoticesDao.insertNotice(notice);
    }

    @Override
    public Notice FindNoticeById(String id) {
        return adminNoticesDao.selectNoticeById(id);
    }

    @Override
    public int modifyNotice(Notice notice) {
        return adminNoticesDao.updateNoticeById(notice);
    }

    @Override
    public int removeNotice(String id) {
        return adminNoticesDao.deleteNotice(id);
    }
}
