package com.demo.mvc.controller;

import com.demo.mvc.model.User;
import com.demo.mvc.service.StudentManageService;
import com.demo.mvc.service.UserService;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by XYY78 on 2016/10/9.
 */

@Controller
@RequestMapping(value = "/passport")
public class LoginController {

    @Autowired
    private UserService userService;

    // 登录请求
    @RequestMapping(value = "/login")
    @RequiresRoles("admin")
    public String login(Model model,HttpServletRequest request) {
        String exceptionClassName = (String)request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("error", error);
        System.out.println(".................." + error  );
        Session session = SecurityUtils.getSubject().getSession();
        System.out.print("session : "+session.getId());
        System.out.print("session : ");
        return "login/index";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model,HttpServletRequest request) {
        SecurityUtils.getSubject().logout();
        return "login/login";
    }
    // 登录页面
    @RequestMapping("/homepage")
    public String login(HttpServletRequest request , HttpServletResponse response) {
        return "login/login";
    }

    // 没有权限页面
    @RequestMapping("/unauthorized")
    public String unauthorized(HttpServletRequest request, HttpServletResponse response){
        return "/login/unauthorized";
    }

    // 用户有角色
    @RequestMapping("/successed")
    public String successed(HttpServletRequest request, HttpServletResponse response){
        return "login/hasRole";
    }

    // 注册页面
    @RequestMapping("/register")
    public String register(HttpServletRequest request , HttpServletResponse response) {
        return "login/register";
    }

    // 用户注册操作
    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    public String userRegister(User user ,Model model){
        userService.createEndUser(user);
        String registerResult;
        if( user.getId() != null && user.getId() > 0 ) { // 注册成功
            registerResult = "success";
        } else { // 注册失败
            registerResult = "failed";
        }
        model.addAttribute("result",registerResult);
        model.addAttribute("userName", user.getUsername() +"_" + user.getId());
        return "login/registerSuccess";
    }

}
