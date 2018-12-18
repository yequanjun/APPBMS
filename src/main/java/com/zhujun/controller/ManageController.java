package com.zhujun.controller;

import com.zhujun.pojo.*;
import com.zhujun.service.ManageUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/doManage")
public class ManageController {
    @Resource
    private ManageUserService manageUserService;

    //去管理员登录
    @RequestMapping("/toManageLogin")
    public String toManageLogin() {
        return "backendlogin";
    }


    //管理员登录
    @RequestMapping("/ManageLogin")
    public String ManageLogin(BackendUser backendUser, HttpSession session) {
        System.out.println("manageUserService" + manageUserService == null);
        BackendUser backendUser1 = manageUserService.ManageLogin(backendUser);
        session.setAttribute("userSession", backendUser1);
        return "backend/main";
    }

    //管理员注销
    @RequestMapping("/loginout")
    public String loginout(HttpSession session) {
        session.removeAttribute("userSession");
        return "redirect:/index.jsp";
    }
}
