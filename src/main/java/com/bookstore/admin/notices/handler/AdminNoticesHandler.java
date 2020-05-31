package com.bookstore.admin.notices.handler;

import com.bookstore.admin.notices.service.IAdminNoticesService;

import com.bookstore.commons.beans.Notice;
import com.bookstore.commons.beans.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/5/27
 */
@Controller
@RequestMapping("/admin/notices")
public class AdminNoticesHandler {

    @Autowired
    IAdminNoticesService adminNoticesService;

    //公告查询
    @RequestMapping("/ListNoticeServlet")
    public String ListNoticeServlet(Model model){
        List<Notice> notices=adminNoticesService.ListNoticeServlet();
        // for (Notice n:notices){
        //     System.out.println(n);
        // }
        model.addAttribute("notices",notices);
        return "/admin/notices/list.jsp";
    }

    //添加公告
    @RequestMapping("/AddNotice")
    public String AddNotice(Notice notice){
       int rows= adminNoticesService.AddNotice(notice);
       if (rows>0){
           return "redirect:/admin/notices/ListNoticeServlet";//添加成功则执行查询方法
       }else {
           return "/admin/notices/error.jsp";//添加失败则返回失败页面
       }
    }

    //修改公告1.按id查询公告显示
    @RequestMapping("/FindNoticeById")
    public String FindNoticeById(String id,Model model){
        Notice notice=adminNoticesService.FindNoticeById(id);
       // System.out.println(notice);
        model.addAttribute("n",notice);
        return "/admin/notices/edit.jsp";

    }
    //修改公告2.按id查询公告到之后修改数据
    @RequestMapping("modifyNotice")
    public String modifyNotice(Notice notice){
        int rows=adminNoticesService.modifyNotice(notice);
        if (rows>0){
            return "redirect:/admin/notices/ListNoticeServlet";//修改成功则执行查询方法
        }else {

            return "/admin/notices/fail.jsp";//公告信息修改失败则返回失败页面
        }
    }
    //删除公告
    @RequestMapping("/removeNotice")
    public String removeNotice(String id){
        int rows=adminNoticesService.removeNotice(id);
        if (rows>0){
            return "redirect:/admin/notices/ListNoticeServlet";
        }else {
            return "/admin/notices/removeerror.jsp";
        }

    }
}
