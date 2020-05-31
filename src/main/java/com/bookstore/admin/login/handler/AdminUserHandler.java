package com.bookstore.admin.login.handler;

import com.bookstore.admin.login.service.IAdminUserService;
import com.bookstore.commons.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * company: www.abc.com
 * Author: 29746
 * Create Data: 2020/5/11
 */
@Controller
@RequestMapping("/admin/login")
public class AdminUserHandler {
    @Autowired
    IAdminUserService adminUserService;
    //管理员登陆
    @RequestMapping("/login")
    public String login(User user, Model model,HttpSession session){
       // System.out.println("登录用户："+user);
        User login_user=adminUserService.findUserByLogin(user);
        if (login_user!=null){
            //用户名和密码正确，并且是超级用户
            if ("超级用户".equals(login_user.getRole())){
                session.setAttribute("login_user",login_user);
                return "/admin/login/home.jsp";
            }else {
                //用户名和密码正确但为普通用户
                return "/admin/error/privilege.jsp";
            }
        }else{ model.addAttribute("fail","用户名或密码错误，请重新输入！");
            return "/admin/login/login.jsp"; } }
    @RequestMapping("/test")
    public  String test(){
        return "/admin/login/home.jsp";
    }
    //管理员退出
    @RequestMapping("/logout")
    public String logout(Model model,HttpSession session){
        session.removeAttribute("login_user");
        model.addAttribute("fail","用户退出成功，请重新登录！");
        return "/admin/login/login.jsp";
    }
}







